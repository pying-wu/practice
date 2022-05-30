<template>
  <!-- 排版 -->
  <div class="container mt-sm-2">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <!-- 表單控制 -->
        <form id="form" method="post" @submit.prevent="validateForm()">
          <!-- 帳號 -->
          <div class="form-group">
            <label for="username">帳號</label>
            <input id="username" name="username" type="text" class="form-control" v-model="user.username" :class="{
                active: isActive,
                'is-invalid': attemptSubmit && missingUserName(),
              }" />
            <!-- 顯示錯誤訊息-->
            <div v-if="attemptSubmit && missingUserName()" :class="{
                'invalid-feedback': attemptSubmit && missingUserName(),
              }">
              帳號不得為空
            </div>
          </div>
          <!-- 舊密碼 -->
          <div class="form-group mt-2 flex-row">
            <label class="form-control-label" for="oldPassword">舊密碼</label>
            <div class="d-flex flex-row">
              <input id="oldPassword" name="oldPassword" class="form-control" :type="oldPasswordFieldType"
                v-model="user.oldPassword" :class="{ 'is-invalid': attemptSubmit && missingOldPassword() }" />
              <button type="button" class="btn" @click="OldSwitchVisibility()">
                <font-awesome-icon :icon="['fas', oldisActive ? 'eye-slash' : 'eye']"></font-awesome-icon>
              </button>
            </div>

            <!-- 顯示錯誤訊息-->
            <div class="d-flex" v-if="attemptSubmit && missingOldPassword()" :class="{
                'invalid-feedback': attemptSubmit && missingOldPassword(),
              }">
              密碼不得為空
            </div>
          </div>
          <!-- 新密碼 -->
          <div class="form-group mt-2">
            <label class="form-control-label" for="password">新密碼</label>
            <div class="d-flex flex-row">
              <input id="password" name="password" class="form-control" :type="passwordFieldType"
                v-model="user.password" :class="{ 'is-invalid': attemptSubmit && missingPassword() }" />
              <button type="button" @click="switchVisibility()" class="btn">
                <font-awesome-icon :icon="['fas', isActive ? 'eye-slash' : 'eye']"></font-awesome-icon>
              </button>
            </div>
            <!-- 顯示錯誤訊息-->
            <div class="d-flex" v-if="attemptSubmit && missingPassword()" :class="{
                'invalid-feedback': attemptSubmit && missingPassword(),
              }">
              密碼不得為空
            </div>
          </div>
          <!-- 確認密碼 -->
          <div class="form-group mt-2">
            <label class="form-control-label" for="confirm">確認密碼</label>
            <div class="d-flex">
              <input id="confirm" name="confirm" class="form-control" :type="confirmPasswordFieldType"
                v-model="user.confirm" :class="{ 'is-invalid': attemptSubmit && confirmPassword() }" />
              <button type="button" @click="confirmSwitchVisibility()" class="btn">
                <font-awesome-icon :icon="['fas', confirmisActive ? 'eye-slash' : 'eye']"></font-awesome-icon>
              </button>
            </div>
            <!-- 顯示錯誤訊息-->
            <div class="d-flex" v-if="attemptSubmit && confirmPassword()" :class="{
                'invalid-feedback': attemptSubmit && confirmPassword(),
              }">
              確認密碼不一致
            </div>
          </div>
          <!-- 送出按鈕 -->
          <div class="d-grid gap-2 mt-4">
            <button class="btn btn-primary text-center" type="submit">
              送出
            </button>
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
// 提交檢查是否顯示錯誤訊息
let attemptSubmit = ref(false);
// 舊密碼
let oldPasswordFieldType = ref("password");
// 切換舊密碼的 eye/ eye-slash
let oldisActive = ref(true);
// 新密碼
let passwordFieldType = ref("password");
// 切換新密碼的 eye/ eye-slash
let isActive = ref(true);
// 確認密碼
let confirmPasswordFieldType = ref("password");
// 切換確認密碼的 eye/ eye-slash
let confirmisActive = ref(true);
// 表格資訊
let user = reactive({
  // 帳號
  username: "",
  // 舊密碼
  oldPassword: "",
  // 新密碼
  password: "",
  // 確認密碼
  confirm: "",
});

// =======================================================
// = function
// =======================================================

// 舊密碼顯示/隱藏
function OldSwitchVisibility() {
  oldPasswordFieldType.value =
    oldPasswordFieldType.value === "password" ? "text" : "password";
  oldisActive.value = !oldisActive.value;
}

// 新密碼顯示/隱藏
function switchVisibility() {
  passwordFieldType.value =
    passwordFieldType.value === "password" ? "text" : "password";
  isActive.value = !isActive.value;
}

// 確認密碼顯示/隱藏
function confirmSwitchVisibility() {
  confirmPasswordFieldType.value =
    confirmPasswordFieldType.value === "password" ? "text" : "password";
  confirmisActive.value = !confirmisActive.value;
}

// 帳號不得為空
function missingUserName() {
  return user.username.trim() === "";
}

// 舊密碼不得為空
function missingOldPassword() {
  return user.oldPassword.trim() === "";
}

// 新密碼不得為空
function missingPassword() {
  return user.password.trim() === "";
}

// 密碼不等於確認密碼
function confirmPassword() {
  return user.password != user.confirm || user.confirm.trim() === "";
}

// 表單檢驗
function validateForm(event) {
  attemptSubmit.value = true;
  if (
    missingUserName() ||
    missingOldPassword() ||
    missingPassword() ||
    confirmPassword()
  ) {
    event.preventDefault();
  } else {
    router.push("/login/forgot/reset/success");
    return;
  }
}
</script>

