<template>
    <NavBar/>
    <BreadCrumb/>
    <router-view/>
</template>

<script setup>
    import NavBar from "@/components/layouts/navigation/NavBar.vue";
    import BreadCrumb from "@/components/layouts/breadcrumb/BreadCrumb.vue";

</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #2c3e50;
    }

    nav {
        padding: 30px;
    }

    nav a {
        font-weight: bold;
        color: #2c3e50;
    }

    nav a.router-link-exact-active {
        color: #42b983;
    }

    .tdiv {
        text-align: center;
    }

    .redstar {
        color: red;
    }

    .rdiv {
        height: 30px;
        /*position: center;*/
        margin-left: 10px;
        margin-top: 5px;
        margin-right: 6px;
    }

    .cbutton {
        margin-left: 10%;
        border-radius: 4px;
        border: 2px;
        border-color: #2c3e50;
    }

    .cbox {
        margin-bottom: 22px;
        background-color: white;
        border: 1px solid transparent;
        border-radius: 4px;
        border-color: #2c3e50;
        margin-left: 13%;
        margin-right: 13%;
        width: 75%;
        padding: 2% 1%;
    }

    .sbox {
        padding-top: 22px;
        padding-bottom: 22px;
        background-color: white;
        border: 1px solid transparent;
        border-radius: 3px;
        border-color: #2c3e50;
        margin-left: 13%;
        margin-right: 13%;
        width: 75%;
        padding-left: 1%;
        padding-right: 1%
    }

    .radio {
        margin-left: 25%;
        padding: 5px;
    }

</style>
