<template>
  <!-- 上方導航欄 -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <!-- 導航欄標題 -->
      <a class="navbar-brand" href="/index">後臺管理</a>
      <!-- 下拉選單 -->
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <!-- 下拉主標題 -->
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li v-for="item in menuList" :key="item.index" class="nav-item dropdown">
            <template v-if="item.subList">
              <!-- 標題名 -->
              <a class="nav-link dropdown-toggle" :href="item.url" :title="item.name" id="navbarDropdown" role="button"
                data-bs-toggle="dropdown" aria-expanded="false">
                {{ item.name }}
              </a>
              <!-- 下拉子標題 -->
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li v-for="{ url, name, index } in item.subList" :key="index">
                  <!-- 標題名 -->
                  <a class="dropdown-item" :href="url">{{ name }}</a>
                </li>
              </ul>
            </template>
          </li>
        </ul>
        <!-- 顯示登入使用者名字 -->
        <div class="navbar-brand" style="color: white">
          {{ user }}
        </div>
        <!-- 登入登出按鈕 -->
        <a href="/login">
          <input :class="addClass()" :value="changeButton()" class="btn" type="button" @click="logout()" />
        </a>
      </div>
    </div>
  </nav>
</template>

<script setup>
import { ref } from "@vue/reactivity";
import { useCookies } from "vue3-cookies";
import { useRouter } from "vue-router";
import { onMounted } from "@vue/runtime-core";

// =======================================================
// = data
// =======================================================
let user = ref("");
const cookies = useCookies();
const router = useRouter();
const menuList = [
  {
    url: "#",
    name: "使用",
    subList: [
      {
        url: "/user/1",
        name: "使用一",
      },
      {
        url: "/user/2",
        name: "使用二",
      },
      {
        url: "/user/3",
        name: "使用三",
      },
    ],
  },
  {
    url: "#",
    name: "角色",
    subList: [
      {
        url: "/role/1",
        name: "角色一",
      },
      {
        url: "/role/2",
        name: "角色二",
      },
      {
        url: "/role/3",
        name: "角色三",
      },
    ],
  },
  {
    url: "#",
    name: "授權項目",
    subList: [
      {
        url: "/authorized/1",
        name: "授權一",
      },
      {
        url: "/authorized/2",
        name: "授權二",
      },
      {
        url: "/authorized/3",
        name: "授權三",
      },
    ],
  },
  {
    url: "#",
    name: "載具(卡片)專區",
    subList: [
      {
         url: "/apconsumer/1",
         name: "載具中獎發票查詢",
      },
      {
         url: "/apconsumer/2",
         name: "載具消費發票查詢",
      },
      {
         url: "/apconsumer/3",
         name: "載具中獎通知設定",
      },
    ],
  },
];

// 獲取username
onMounted(() => {
  user.value = cookies.cookies.get("username");
});
// =======================================================
// = function
// =======================================================

// 登出清除cookies裡的username
function logout() {
  cookies.cookies.remove("username");
  router.push("/push");
}

// 根據得到cookie與否改變按鈕顏色
function addClass() {
  if (cookies.cookies.isKey("username")) {
    return "btn-warning";
  } else {
    return "btn-primary";
  }
}

// 根據得到cookie與否改變按鈕文字
function changeButton() {
  if (cookies.cookies.isKey("username")) {
    return "登出";
  } else {
    return "登入";
  }
}
</script>

<style scoped>
.navbar-brand {
  margin: 0 30px 0 10px;
}
#login:active {
  background-color: warning;
}
</style>