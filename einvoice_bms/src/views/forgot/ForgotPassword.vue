<template>
  <div class="container mt-sm-3">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <!-- 表單控制 -->
        <form id="form" method="post" @submit.prevent="validateForm()">
          <!-- 帳號 -->
          <div class="form-group">
            <label for="username">帳號</label>
            <input id="username" name="username" type="text" class="form-control" v-model="user.username"
              :class="{ 'is-invalid': attemptSubmit && missingUserName() }" />
            <!-- 顯示錯誤訊息-->
            <div v-if="attemptSubmit && missingUserName()" :class="{
                'invalid-feedback': attemptSubmit && missingUserName(),
              }">
              帳號不得為空
            </div>
          </div>
          <!-- 信箱 -->
          <div class="form-group">
            <label for="email">信箱</label>
            <input id="email" name="email" type="email" class="form-control" v-model="user.email"
              :class="{ 'is-invalid': attemptSubmit && checkEmail() }" />
            <!-- 顯示錯誤訊息-->
            <div v-if="attemptSubmit && checkEmail()" :class="{ 'invalid-feedback': attemptSubmit && checkEmail() }">
              信箱不符合格式
            </div>
            <!-- 顯示錯誤訊息-->
            <div v-if="attemptSubmit && missingEmail()" :class="{
                'invalid-feedback': attemptSubmit && missingEmail(),
              }">
              信箱不得為空
            </div>
          </div>
          <!-- 按鈕 -->
          <div class="d-grid gap-2 mt-4">
            <button class="btn btn-primary text-center">重發密碼</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script setup>
import { reactive, ref } from "@vue/reactivity";
import { useRouter } from "vue-router";

// =======================================================
// = data
// =======================================================
// router
const router = useRouter();
// 信箱規則
const reg = /^([a-zA-Z]|[0-9])+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
// 提交檢查是否顯示錯誤訊息
let attemptSubmit = ref(false);
// 表格資訊
let user = reactive({
  // 帳號
  username: "",
  // 信箱
  email: "",
});

// =======================================================
// = function
// =======================================================

// 帳號不得為空
function missingUserName() {
  return user.username.trim() === "";
}

// 信箱需包含@.c
function checkEmail() {
  return !reg.test(user.email);
}

// 信箱不得為空
function missingEmail() {
  return user.email.trim() === "";
}

// 表單檢驗
function validateForm(event) {
  attemptSubmit.value = true;
  if (missingUserName() || checkEmail() || missingEmail()) {
    event.preventDefault();
  } else {
    router.push("/login/forgot/success");
    return;
  }
}
</script>
