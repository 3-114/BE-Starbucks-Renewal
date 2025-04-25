<div align="center">

# Team 114

![스파로스 114 로고 이미지](https://github.com/user-attachments/assets/52cd0249-474b-4ba7-90e7-b2554602aca9)

</div>

<br>
<br>
<br>

---

<div align="center">
	
# 📖 프로젝트 개요

</div>

<br>
<br>


> #### ✨ 신세계 I&C [스파로스 6기](https://swedu.spharosacademy.com/spharos_total.html) - 리빌딩 프로젝트
> #### ⏫ 스타벅스 내 Shopping 서비스를 새롭게 구현 및 성능 개선
> #### 📅 개발 기간 : 2025년 3월 10일 ~ 4월 28일
> #### 🌐 홈페이지 : https://www.starbucks-renewal.shop/

<br>
<br>
<br>

---

<div align="center" style="font-size: 32px; font-weight: bold; color: #f4a261;">
	
# 👥 팀원 소개

</div>

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

  <!-- 역할 라인 (Frontend / Backend) -->
  <tr>
    <td align="center"><div class="role-box frontend">🖥️ Frontend</div></td>
    <td align="center"><div class="role-box backend">⚙️ Backend</div></td>
    <td align="center"><div class="role-box backend">⚙️ Backend</div></td>
    <td align="center"><div class="role-box backend">⚙️ Backend</div></td>
    <td align="center"><div class="role-box devops">☁️ DevOps</div></td>
  </tr>

  <!-- 담당 업무 -->
  <tr>
    <td>
      <ul>
        <li align="center">메인 페이지</li>
        <li align="center">상품 상세페이지</li>
        <li align="center">장바구니 페이지</li>
      </ul>
    </td>
    <td>
      <ul>
        <li align="center">상품 카테고리</li>
        <li align="center">이벤트(기획전)</li>
        <li align="center">QueryDSL</li>
      </ul>
    </td>
    <td>
      <ul>
        <li align="center">로그인/회원가입</li>
        <li align="center">JWT, Security</li>
        <li align="center">장바구니</li>
      </ul>
    </td>
    <td>
      <ul>
        <li align="center">회원 배송지</li>
        <li align="center">상품 상세 옵션</li>
        <li align="center">데이터 전처리/삽입</li>
      </ul>
    </td>
    <td>
      <ul>
        <li align="center">상품 기능</li>
        <li align="center">상품 이미지 관리</li>
        <li align="center">CI/CD</li>
      </ul>
    </td>
  </tr>
</table>
</div>

<br>
<br>
<br>

---

<div align="center">  
	
# 📲 Porting Manual

</div>

<br>

<div align="center">

###  🖥️ Front - End

</div>


<br>

<div align="center">

| 항목            | 내용              |
|---------------|-----------------|
| Project Build | Gradle - Groovy |

 
</div>




<br>
<br>  

<div align="center">

###  ⚙️ Back - End  
 
</div>


<div align="center">

| 항목            | 내용              |
|---------------|-----------------|
| Project Build | Gradle - Groovy |
| Language      | Java            |
| Spring Boot   | 3.4.4           |
| Packaging     | Jar             |
 
</div>

<br>

<div align="center">

### Dependencies ↙️

 
</div>



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

<br>

<div align="center">

### ☁️ InfraStructure
 
</div>


<br>



<br>
<br>
<br>

---

<div align="center">
	

# 🖥️ 프로젝트 설명



</div>

<br>
<br>

<div align="center">

### 🏗️ Architecture
 
</div>


<br>

![114-아키텍쳐](https://github.com/user-attachments/assets/58712f9b-50dc-4b0d-ac8d-0e407e7325f4)

<br>
<br>

<div align="center">

### 📝 [ERD 바로가기](https://www.erdcloud.com/d/AfbenbEeNpbLj2dwu)
 
</div>


<br>

![최종 ERD](https://github.com/user-attachments/assets/e484d31e-6d8b-4545-bf7b-1417a835eaf3)

<br>
<br>

---

<div align="center">

# 🎯 기술 스택

</div>

<br>

<div align="center">
	
### 🖥️ Front - End ↙️

</div>


<br>

<div align="center">
  <img src="https://img.shields.io/badge/Next.js-000000?style=flat&logo=nextdotjs&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/TypeScript-3178C6?style=flat&logo=typescript&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/TailwindCSS-06B6D4?style=flat&logo=tailwindcss&logoColor=white" height="28"/>
  <br>
  <img src="https://img.shields.io/badge/Figma-F24E1E?style=flat&logo=figma&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/shadcn/ui-000000?style=flat&logo=react&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/Zod-7C3AED?style=flat&logo=typescript&logoColor=white" height="28"/>
</div>

<br>

<div align="center">
	
### ⚙️ Back - End ↙️
</div>


<br>

<div align="center">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=springboot&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=flat&logo=springsecurity&logoColor=white" height="28"/>
  <br>
  <img src="https://img.shields.io/badge/QueryDSL-009688?style=flat&logo=apachemaven&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/SpringDataJPA-4B8BBE?style=flat&logo=hibernate&logoColor=white" height="28"/>
</div>

<br>

<div align="center">
	
### 🖥️ Collabo ↙️
</div>


<br>

<div align="center">

  <!-- 협업 도구 -->
  <img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=notion&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/Slack-4A154B?style=flat&logo=slack&logoColor=white" height="28"/>
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white" height="28"/>
  <br>

  <!-- 개발 도구 -->
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=flat&logo=intellijidea&logoColor=white" height="28"/>
<img src="https://img.shields.io/badge/VSCode-007ACC?style=flat&logo=visualstudiocode&logoColor=white" height="28"/>
<img src="https://img.shields.io/badge/AWS-FF9900?style=flat&logo=amazonaws&logoColor=white" height="28"/>
</div>

<br>
