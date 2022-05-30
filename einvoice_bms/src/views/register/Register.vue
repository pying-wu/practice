<template>
  <!-- 註冊排版 -->
  <div class="container mt-sm-2">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <!-- 註冊表單控制 -->
        <form id="form" method="post" @submit.prevent="validateForm">
          <!-- 帳號 -->
          <div class="form-group">
            <label for="username">帳號</label>
            <input id="username" name="username" type="text" class="form-control" v-model="user.username" :class="{
                active: isActive,
                'is-invalid': attemptSubmit && checkUser(),
              }" />
            <!-- 顯示帳號長度錯誤訊息-->
            <div v-if="attemptSubmit && checkUsernameLength()" :class="{
                'invalid-feedback': attemptSubmit && checkUsernameLength(),
              }">
              帳號長度需大於等於6個字元
            </div>
            <!-- 顯示帳號錯誤訊息-->
            <div v-if="showUserMessage" :class="{
                'invalid-feedback': showUserMessage,
              }">
              {{ userMessage }}
            </div>
          </div>
          <!-- 姓名 -->
          <div class="form-group">
            <label for="name">姓名</label>
            <input id="name" name="name" type="text" class="form-control" v-model="user.name"
              :class="{ 'is-invalid': attemptSubmit && missingName() }" />
            <!-- 顯示姓名錯誤訊息-->
            <div v-if="attemptSubmit && missingName()" :class="{
                'invalid-feedback': attemptSubmit && missingName(),
              }">
              姓名不得為空
            </div>
          </div>
          <!-- 密碼 -->
          <div class="form-group mt-2">
            <label class="form-control-label" for="password">密碼</label>
            <div class="d-flex flex-row">
              <input id="password" name="password" class="form-control" :type="passwordFieldType"
                v-model="user.password" :class="{ 'is-invalid': attemptSubmit && checkPassword() }" />
              <button type="button" @click="switchVisibility()" class="btn">
                <font-awesome-icon :icon="['fas', isActive ? 'eye-slash' : 'eye']">
                </font-awesome-icon>
              </button>
            </div>
            <!-- 顯示密碼長度錯誤訊息-->
            <div class="d-flex" v-if="attemptSubmit && checkPasswordLength()" :class="{
                'invalid-feedback': attemptSubmit && checkPasswordLength(),
              }">
              密碼長度需大於等於6個字元
            </div>
            <!-- 顯示密碼錯誤訊息-->
            <div class="d-flex" v-if="showPasswordMessage" :class="{
                'invalid-feedback': showPasswordMessage,
              }">
              {{ passwordMessage }}
            </div>
          </div>
          <!-- 確認密碼 -->
          <div class="form-group mt-2">
            <label class="form-control-label" for="confirm">確認密碼</label>
            <div class="d-flex flex-row">
              <input id="confirm" name="confirm" class="form-control" :type="confirmPasswordFieldType"
                v-model="user.confirm" :class="{ 'is-invalid': attemptSubmit && confirmPassword() }" />
              <button type="button" @click="confirmSwitchVisibility()" class="btn">
                <font-awesome-icon :icon="['fas', confirmisActive ? 'eye-slash' : 'eye']">
                </font-awesome-icon>
              </button>
            </div>
            <!-- 顯示確認密碼錯誤訊息-->
            <div class="d-flex" v-if="attemptSubmit && confirmPassword()" :class="{
                'invalid-feedback': attemptSubmit && confirmPassword(),
              }">
              確認密碼不一致
            </div>
          </div>
          <!-- 註冊按鈕 -->
          <div class="d-grid gap-2 mt-4">
            <button class="btn btn-primary text-center" type="submit">
              註冊
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
import axios from "axios";

// =======================================================
// = data
// =======================================================

// router
const router = useRouter();
// 提交檢查是否顯示錯誤訊息
let attemptSubmit = ref(false);
// 帳號錯誤訊息
let userMessage = ref("");
// 顯示帳號錯誤訊息
let showUserMessage = ref(false);
// 密碼錯誤訊息
let passwordMessage = ref("");
// 顯示密碼錯誤訊息
let showPasswordMessage = ref(false);
let message = ref("");
// 密碼
let passwordFieldType = ref("password");
// 切換密碼的 eye/ eye-slash
let isActive = ref(true);
// 確認密碼
let confirmPasswordFieldType = ref("password");
// 切換確認密碼的 eye/ eye-slash
let confirmisActive = ref(true);
// 註冊資訊
let user = reactive({
  username: "",
  name: "",
  password: "",
  confirm: "",
});

// =======================================================
// = function
// =======================================================

// 檢查帳號
function checkUser() {
  return missingUsername() || checkUsernameLength() || showUserMessage.value;
}

// 帳號不得為空
function missingUsername() {
  return user.username.trim() === "";
}

// 姓名不得為空
function missingName() {
  return user.name.trim() === "";
}

// 檢查密碼
function checkPassword() {
  return (
    missingPassword() ||
    confirmPassword() ||
    checkPasswordLength() ||
    showPasswordMessage.value
  );
}

// 密碼不得為空
function missingPassword() {
  return user.password.trim() === "";
}

// 密碼不等於確認密碼
function confirmPassword() {
  return user.password != user.confirm || user.confirm.trim() === "";
}

// 檢查帳號長度是否小於6
function checkUsernameLength() {
  return user.username.trim().length < 6;
}

// 檢查密碼長度是否小於6
function checkPasswordLength() {
  return user.password.trim().length < 6;
}

// 密碼顯示/隱藏
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

// 表單檢驗
function validateForm(event) {
  attemptSubmit.value = true;
  if (
    missingUsername() ||
    missingName() ||
    missingPassword() ||
    confirmPassword() ||
    checkUsernameLength() ||
    checkPasswordLength()
  ) {
    event.preventDefault();
  } else {
    // ajax
    axios
      .post(
        "/api" + "/registryPasswordPolicy",
        {
          userId: user.username,
          userPassword: user.password,
          userName: user.name,
        },
        { headers: { "Content-Type": "application/json" } }
      )
      .then((response) => {
        if (response.data.status === "error") {
          if (response.data.message_code === "AN002") {
            // 設定訊息 = 後端的訊息
            userMessage.value = response.data.message;
            // 顯示帳號錯誤訊息
            showUserMessage.value = true;
            // 隱藏密碼錯誤訊息
            showPasswordMessage.value = false;
          } else if (response.data.message_code === "AP002") {
            // 隱藏帳號錯誤訊息
            showUserMessage.value = false;
            // 顯示密碼錯誤訊息
            showPasswordMessage.value = true;
            // 設定訊息 = 後端的訊息
            passwordMessage.value = "請檢查密碼複雜度";
          } else {
            // A0002
            message.value = "帳號、密碼、姓名任一欄位不能為空";
          }
          event.preventDefault();
        } else {
          router.push("/register/success");
          return;
        }
      });
  }
}
</script>

