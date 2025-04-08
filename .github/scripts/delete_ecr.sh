#!/bin/bash

# 환경 변수 정의
REGION="ap-northeast-2"
REPO_NAME="starbucks-backend"
ACCOUNT_ID="412381782254"

echo "🔍 ECR에서 최신 이미지 3개를 제외한 나머지를 삭제합니다..."

# 모든 이미지 목록을 'pushedAt' 기준으로 정렬하여 가져옴
images=$(aws ecr describe-images \
  --region $REGION \
  --repository-name $REPO_NAME \
  --query 'sort_by(imageDetails,& imagePushedAt)[*].imageDigest' \
  --output text)

# 이미지 총 개수
image_count=$(echo "$images" | wc -w)
echo "📦 총 이미지 개수: $image_count"

# 3개 이하면 삭제할 게 없음
if [ "$image_count" -le 3 ]; then
  echo "✅ 최신 3개 이하만 존재하므로 삭제할 이미지 없음."
  exit 0
fi

# 삭제할 이미지 목록: 가장 최근 3개를 제외한 나머지
delete_images=$(echo "$images" | awk '{for(i=1;i<=NF-3;i++) print $i}')

# 삭제 실행
for digest in $delete_images; do
  echo "🗑 삭제 중: $digest"
  aws ecr batch-delete-image \
    --region $REGION \
    --repository-name $REPO_NAME \
    --image-ids imageDigest=$digest
done

echo "✅ 삭제 완료!"