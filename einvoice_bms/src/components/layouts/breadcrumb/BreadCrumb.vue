<template>
  <div class="content-title-box">
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li>
          <b> {{ title }} </b>
          <!-- <a :href="href">{{ title }}</a> -->
        </li>

        <li class="active" aria-current="page">
          <template v-for="(item, index) in breadList" :key="index">
            <span v-show="showDivider()" class="p-3">></span>
            <b> {{ item.name }}</b>
            <!-- <a v-if="item.name" :href="item.path">
              {{ item.name }}
            </a> -->
          </template>
        </li>
      </ol>
    </nav>
  </div>
</template>

<script setup>
import { onBeforeUpdate, onMounted, ref } from "@vue/runtime-core";
import { useRoute } from "vue-router";
import { watch } from "@vue/runtime-core";

let breadList = ref([]);
let title = ref("");
const route = useRoute();

function getRoute() {
  breadList.value = route.matched;
}

function getTitle() {
  title.value = route.meta.title;
}

function showDivider() {
  return route.meta.title !== "";
}

onMounted(() => {
  getRoute();
});

onBeforeUpdate(() => {
  getTitle();
});

watch(route, (newValue, oldValue) => {
  getRoute();
  console.log("route的值變化了", newValue, oldValue);
});
</script>

<style scoped>
a {
  text-decoration: none;
}
</style>