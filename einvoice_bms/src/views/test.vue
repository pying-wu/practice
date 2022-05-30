
<template>
  <div class="content-title-box">
    <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li>
          <a :to="{ path: '#' }">{{ title }}</a>
        </li>

        <li class="breadcrumb-item">
          <template v-for="(item, index) in breadList" :key="index">
            <span v-show="showDivider()" class="p-3">></span>
            <a v-if="item.name" :href="index">
              {{ item.name }}
            </a>
          </template>
        </li>
      </ol>
    </nav>
  </div>
</template>

<script setup>
// import { useRouter, useRoute, onBeforeRouteUpdate } from "vue-router";
import { useRoute } from "vue-router";
import { watch } from "vue";

// data
let route = useRoute();
let breadList = [];
let title = "";
let bread = [];

function showDivider() {
  return bread[0].meta.title !== "";
}

watch(
  () => route.matched,
  () => {
    bread = route.matched;
    breadList = bread[0];
  },
  { deep: true }
);
</script>
<style scoped>
a {
  text-decoration: none;
}
</style>