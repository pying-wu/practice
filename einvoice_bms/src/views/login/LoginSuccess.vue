<template>
  <div class="success">
    <h1>登入成功</h1>
  </div>
</template>
<script setup>
import { onBeforeMount } from "@vue/runtime-core";
onBeforeMount(() => {
  if (location.href.indexOf("#reloaded") == -1) {
    location.href = location.href + "#reloaded";
    location.reload();
  }
});
</script>