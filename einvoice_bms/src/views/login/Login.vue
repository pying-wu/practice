<template>
  <!-- 登入排版 -->
  <div class="container mt-sm-4">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <!-- 登入表單控制 -->
        <form id="form" method="post" @submit.prevent="validateForm()">
          <!-- 帳號 -->
          <div class="form-group">
            <label for="username">帳號</label>
            <input id="username" name="username" type="text" class="form-control" v-model="user.username" :class="{
                'is-invalid':
                  attemptSubmit && checkUser() && !showPasswordMessage,
              }" />
            <!-- 顯示帳號(被鎖)錯誤訊息-->
            <div v-if="showUserMessage" :class="{
                'invalid-feedback': showUserMessage,
              }">
              {{ userMessage }}
            </div>
          </div>
          <!-- 密碼 -->
          <div class="form-group mt-2">
            <label class="form-control-label" for="password">密碼</label>
            <div class="d-flex flex-row">
              <input id="password" name="password" class="form-control" :type="passwordFieldType"
                v-model="user.password" :class="{
                  'is-invalid':
                    attemptSubmit && checkUser() && !showUserMessage,
                }" />
              <button type="button" @click="switchVisibility()" class="btn">
                <font-awesome-icon :icon="['fas', isActive ? 'eye-slash' : 'eye']">
                </font-awesome-icon>
              </button>
            </div>
            <!-- 顯示錯誤訊息 -->
            <div class="d-flex" v-if="
                attemptSubmit &&
                checkUser() &&
                !showUserMessage &&
                !showPasswordMessage
              " :class="{ 'invalid-feedback': attemptSubmit && checkUser() }">
              密碼或帳號錯誤
            </div>
            <!-- 顯示密碼(過期)錯誤訊息-->
            <div class="d-flex" v-if="showPasswordMessage" :class="{
                'invalid-feedback': showPasswordMessage,
              }">
              {{ passwordMessage }}
            </div>
          </div>
          <!-- 登入按鈕 -->
          <div class="d-grid gap-2 mt-4">
            <button class="btn btn-primary text-center">登入</button>
          </div>
          <!-- 連結 -->
          <div class="href">
            <!-- 忘記密碼連結 -->
            <span class="forgot">
              <a href="/login/forgot">忘記密碼?</a>
            </span>
            <!-- 註冊帳號連結 -->
            <span class="register">
              <a href="/register">註冊帳號</a>
            </span>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from "@vue/reactivity";
import { useCookies } from "vue3-cookies";
import { useRouter } from "vue-router";
import axios from "axios";

// =======================================================
// = data
// =======================================================
// cookies
const cookies = useCookies();
// router
const router = useRouter();
// 密碼
let passwordFieldType = ref("password");
// 切換密碼的 eye/ eye-slash
let isActive = ref(true);
// 帳號(被鎖)錯誤訊息
let userMessage = ref("");
// 顯示帳號(被鎖)錯誤訊息
let showUserMessage = ref(false);
// 密碼(過期)錯誤訊息
let passwordMessage = ref("");
// 顯示密碼(過期)錯誤訊息
let showPasswordMessage = ref(false);
// 提交檢查是否顯示錯誤訊息
let attemptSubmit = ref(false);
// 表格資訊
let user = reactive({
  // 帳號
  username: "",
  // 密碼
  password: "",
  // 是否登入
  isLogin: true,
});

// =======================================================
// = function
// =======================================================

// 帳號不得為空
function missingUsername() {
  return user.username === "" || user.username === null;
}

// 密碼不得為空
function missingPassword() {
  return user.password === "" || user.password === null;
}

// 檢查帳號密碼是否正確
function checkUser() {
  return user.isLogin === false;
}
// 密碼顯示/隱藏
function switchVisibility() {
  passwordFieldType.value =
    passwordFieldType.value === "password" ? "text" : "password";
  isActive.value = !isActive.value;
}

// 表單檢驗
function validateForm(event) {
  attemptSubmit.value = true;
  if (missingUsername() || missingPassword()) {
    user.isLogin = false;
    event.preventDefault();
  } else {
    axios
      .get("/api" + "/loginPasswordPolicy", {
        params: {
          userId: user.username,
          userPassword: user.password,
        },
      })
      .then((response) => {
        if (response.data.status === "error") {
          if (response.data.message_code === "AL001") {
            // 設定訊息 = 後端的訊息
            userMessage.value = response.data.message;
            // 顯示帳號(被鎖)錯誤訊息
            showUserMessage.value = true;
            // 隱藏密碼(過期)錯誤訊息
            showPasswordMessage.value = false;
          } else if (response.data.message_code === "AE001") {
            // 設定訊息 = 後端的訊息
            passwordMessage.value = response.data.message;
            // 隱藏帳號(被鎖)錯誤訊息
            showUserMessage.value = false;
            // 顯示密碼(被鎖)錯誤訊息
            showPasswordMessage.value = true;
          } else {
            showUserMessage.value = false;
            showPasswordMessage.value = false;
            userMessage.value = "";
            passwordMessage.value = "";
            console.log(response.data);
          }
          user.isLogin = false;
          event.preventDefault();
        } else {
          user.isLogin = true;
          cookies.cookies.set("username", user.username);
          router.push({
            name: "登入成功",
            params: { username: user.username },
          });
          return;
        }
      });
  }
}
</script>

<style scoped>
#login {
  margin-top: 30px;
}
.href {
  margin-top: 10px;
}

.register {
  float: right;
}

a {
  text-decoration: none;
}
</style>
