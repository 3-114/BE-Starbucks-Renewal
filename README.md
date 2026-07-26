

<br>

<table style="width:80%;">
  <thead>
    <tr>
      <th style="width:10%;">번호</th>
      <th style="width:90%;">제목</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td><a href="#1-기획">기획</a></td>
    </tr>
    <tr>
      <td>2</td>
      <td><a href="#2-팀원-소개">팀원 소개</a></td>
    </tr>
    <tr>
      <td>3</td>
      <td><a href="#3-개발-환경">개발 환경</a></td>
    </tr>
    <tr>
      <td>4</td>
      <td><a href="#4-주요-기능">주요 기능</a></td>
    </tr>
    <tr>
      <td>5</td>
      <td><a href="#5-설계-문서">설계 문서</a></td>
    </tr>
    <tr>
      <td>6</td>
      <td><a href="#6-프로젝트-규칙">프로젝트 규칙</a></td>
    </tr>
    <tr>
      <td>7</td>
      <td><a href="#7-포팅-매뉴얼">포팅 매뉴얼</a></td>
    </tr>
  </tbody>
</table>

<br>
<br>

# 1. 기획

<div align="center">

# Team 114

![스파로스 114 로고 이미지](https://github.com/user-attachments/assets/52cd0249-474b-4ba7-90e7-b2554602aca9)

</div>

> #### ✨ 신세계 I&C [스파로스 6기](https://swedu.spharosacademy.com/spharos_total.html) - 리빌딩 프로젝트
> #### ⏫ 스타벅스 내 Shopping 서비스를 새롭게 구현 및 성능 개선
> #### 📅 개발 기간 : 2025년 3월 10일 ~ 4월 28일
> #### 🌐 홈페이지 : https://www.starbucks-renewal.shop/

<br>

---

# 2. 팀원 소개

<br>
<br>

<div align="center">
<table>
  <tr>
    <td align="center"><a href="https://github.com/Demopeu">김동현</a></td>
    <td align="center"><a href="https://github.com/DoNalD-A">👑 송민석</a></td>
    <td align="center"><a href="https://github.com/Ahn-donghwan">안동환</a></td>
    <td align="center"><a href="https://github.com/EUNSEO-YA">오은서</a></td>
    <td align="center"><a href="https://github.com/chuman0216">추지우</a></td>
  </tr>

  <tr>
    <td align="center"><div class="role-box frontend">🖥️ Frontend</div></td>
    <td align="center"><div class="role-box backend">⚙️ Backend</div></td>
    <td align="center"><div class="role-box backend">⚙️ Backend</div></td>
    <td align="center"><div class="role-box backend">⚙️ Backend</div></td>
    <td align="center"><div class="role-box devops">☁️ DevOps</div></td>
  </tr>

  <tr>
    <td align="center">
      메인 페이지<br>
      상품 상세페이지<br>
      장바구니 페이지
    </td>
    <td align="center">
      상품 카테고리<br>
      이벤트(기획전)<br>
      QueryDSL
    </td>
    <td align="center">
      로그인/회원가입<br>
      JWT, Security<br>
      장바구니
    </td>
    <td align="center">
      회원 배송지<br>
      상품 상세 옵션<br>
      데이터 전처리/삽입
    </td>
    <td align="center">
      상품 기능<br>
      상품 이미지 관리<br>
      CI/CD
    </td>
  </tr>
</table>
</div>

<br>
<br>
<br>

---

# 3. 개발 환경

### Backend

| Name            | Version                      |
|-----------------|------------------------------|
| OS              | Ubuntu : 22.04, Windows : 11 |
| Java            | 17                           |
| Spring Boot     | 3.4.4                        |
| Gradle - Groovy | 8.13                         |

### DB

| Name  | Version |
|-------|---------|
| MySQL | 9.2.0   |

### Infra
| 항목           | 내용                                 |
|--------------|------------------------------------|
| Spec         | AWS EC2 T3 Medium                  |
| Frontend Url | https://www.starbucks-renewal.shop |
| Backend Url  | https://web.starbucks-renewal.shop |
| OS           | Ubuntu 24.04.2 LTS                 |


---

# 4. 주요 기능

| 로그인 | 장바구니 | 기획전 |
|:------:|:------:|:------:|
| ![로그인](https://github.com/user-attachments/assets/ce5d47fc-7d8b-4e71-bf9c-309dba8d9419) | ![장바구니](https://github.com/user-attachments/assets/1e01c531-c124-4be3-9669-919cd5b78dc2) | ![기획전](https://github.com/user-attachments/assets/57332611-4430-4934-aacc-71886ad6d116) |

| 메인 | 베스트 | 카테고리 |
|:----:|:----:|:----:|
| ![메인](https://github.com/user-attachments/assets/5f8bd568-e6aa-4e84-8e2e-876cf7c6315d) | ![베스트](https://github.com/user-attachments/assets/9442fd63-6d9a-4194-8c78-dbb9ca9ddb98) | ![카테고리](https://github.com/user-attachments/assets/c34a57e2-2d93-4a28-9d82-c34b40aa4163) |


---

# 5. 설계 문서

| 시스템 아키텍쳐 |
| --- |
| ![시스템 아키텍쳐](https://github.com/user-attachments/assets/e816d140-effc-4a74-9e66-04b9444d9da9) |


| CI/CD 아키텍쳐 |
| --- |
| ![cicd 아키텍쳐](https://github.com/user-attachments/assets/12cc8bba-badd-4a5b-8f7d-0c099efee348) |


| [ERD 설계](https://github.com/3-114/.github/blob/main/profile/docs/erd-detail.md) |
| --- |
| [![ERD 설계](https://github.com/3-114/.github/raw/main/profile/img/erd.png)](https://github.com/3-114/.github/blob/main/profile/docs/erd-detail.md) |


| [요구사항 정의서](https://funky-baron-4b5.notion.site/1bc02141a4b3810fa400e69f078ac5ab?pvs=73) |
| --- |
| [![요구사항 정의서](https://github.com/3-114/.github/raw/main/profile/img/requirement.png)](https://funky-baron-4b5.notion.site/1bc02141a4b3810fa400e69f078ac5ab?pvs=73) |

| [API 명세서](https://funky-baron-4b5.notion.site/API-1b502141a4b3804485b7ef524f753b4a) |
| --- |
| [![API 명세서](https://github.com/3-114/.github/raw/main/profile/img/apiSpecification.png)](https://funky-baron-4b5.notion.site/API-1b502141a4b3804485b7ef524f753b4a) |


---

# 6. 프로젝트 규칙

### 1. 커밋 메시지 구조
커밋 메시지는 제목, 본문, 그리고 꼬리말로 구성됩니다.
[<스코프>]<타입>: <제목>

<본문>

<꼬리말>

#### *스코프(Scope)*
변경 사항의 범위를 나타냅니다. 예를 들어, 특정 모듈이나 기능의 이름을 사용할 수 있습니다.
- 예: auth, payment, ui, backend
#### *타입(Type)*
타입의 첫글자는 대문자로 작성합니다.
- *feat*: 새로운 기능 추가
- *fix*: 버그 수정
- *docs*: 문서 변경
- *style*: 코드 포맷팅, 세미콜론 누락 등 비즈니스 로직에 영향을 주지 않는 변경
- *remove*: 파일 삭제
- *refactor*: 코드 리팩토링, 기능 변경 없이 코드 개선
- *test*: 테스트 추가, 수정
- *chore*: 빌드 과정 또는 보조 도구 수정, 패키지 매니저 설정 등
- *perf*: 성능 향상 관련 변경
- *ci*: CI 구성 파일 및 스크립트 변경
- *wip*: 작업 진행 중 임시 저장
#### *제목(Subject)*
제목은 변경 사항을 간략하게 설명합니다. 첫 글자는 대문자로 작성하고, 명령문 형식으로 작성합니다.
- 50자를 넘지 않도록 하며, 마지막에 마침표를 찍지 않습니다.
- 예: [auth]feat: Add JWT authentication
#### *본문(Body)*
본문은 변경 사항의 이유와 주요 내용을 설명합니다. 필요 시 다음과 같은 규칙을 따릅니다:
- 한 줄에 72자를 넘지 않도록 합니다.
- "어떻게" 보다는 "무엇을", "왜" 변경했는지 설명합니다.
- 예:
    - Add JWT authentication to secure API endpoints
    - Update login method to issue JWT tokens
    - Modify user model to store JWT refresh tokens

    
---
### 2. Git 브랜치 작성 컨벤션

#### *브랜치 타입*
브랜치 타입을 명확히 구분하여 브랜치 이름을 작성합니다:
- *feature*: 새로운 기능 개발
- *bugfix*: 버그 수정
- *hotfix*: 긴급 수정
- *release*: 릴리스 준비
- *refactor*: 코드 리팩토링
- *test*: 테스트 관련 작업
- *chore*: 기타 잡무
- *wip*: 작업 진행 중 임시 저장
#### *브랜치 네이밍 규칙*
브랜치 이름은 <타입>/<설명> 형식을 따릅니다. 이슈 번호는 관련된 이슈 트래커의 번호를 사용하고, 설명은 변경 사항을 간략하게 나타냅니다.
- *feature* 브랜치: 새로운 기능 추가
    - 예: feature/login-main
    - feature의 main branch는 -main을 작성합니다.
    - feature의 하위 branch는 다음과 같이 작성합니다. (feature/login/create)
- *bugfix* 브랜치: 버그 수정
    - 예: bugfix/fix-login-error
- *hotfix* 브랜치: 긴급 수정
    - 예: hotfix/critical-bug-fix
- *release* 브랜치: 릴리스 준비
    - 예: release/1.0.0
- *refactor* 브랜치: 코드 리팩토링
    - 예: refactor/optimize-auth-module
- *test* 브랜치: 테스트 관련 작업
    - 예: test/add-unit-tests
- *chore* 브랜치: 기타 잡무
    - 예: chore/update-dependencies
---
### 3. 브랜치 관리
- *main*: 항상 배포 가능한 상태를 유지합니다.
- *develop*: 다음 릴리스에 포함될 기능이 합쳐지는 브랜치입니다.

---

# 7. 포팅 매뉴얼

이 프로젝트는 [Spring](https://spring.io/) 프레임워크 기반 프로젝트입니다.

### 시스템 요구사항

| Name            | Version                      |
|-----------------|------------------------------|
| OS              | Ubuntu : 22.04, Windows : 11 |
| Java            | 17                           |
| Spring Boot     | 3.4.4                        |
| Gradle - Groovy | 8.13                         |
| MySQL           | 9.2.0                        |

### 의존성 및 라이브러리

```bash

	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'

	// Spring Security
	implementation 'org.springframework.boot:spring-boot-starter-security'

	// Jwt
	implementation group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.12.5'
	implementation group: 'io.jsonwebtoken', name: 'jjwt-impl', version: '0.12.5'
	implementation group: 'io.jsonwebtoken', name: 'jjwt-jackson', version: '0.12.5'

	// swagger
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.7.0'

	// Validation
	implementation 'org.springframework.boot:spring-boot-starter-validation'


```

### 포팅 절차

> [1단계] Git 클론 및 프로젝트 폴더 이동  
> [2단계] 환경 설정 파일 수정(application.properties 또는 application.yml)  
> [3단계] DB 마이그레이션 진행  
> [4단계] 로컬 서버 실행
