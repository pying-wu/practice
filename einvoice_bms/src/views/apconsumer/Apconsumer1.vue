<template>
    <div>
        <h1 class="tdiv">載具中獎發票查詢</h1>
    </div>
    <div class="tdiv">
        <p>
            <span class="redstar">*</span>
            為必填(選)欄位，不能為空白
        </p>
    </div>
    <div class="cbox">
        <div>
            <label class="col-sm-3 control-label " style="text-align:right">
                <span class="redstar">*</span>
                載具類型
            </label>
            <select class="rdiv" v-model="apoption" id="apoption">
                <option value="0">手機條碼</option>
                <option value="1">自然人憑證條碼</option>
                <option value="2">悠遊卡</option>
                <option value="3">icash</option>
                <option value="4">一卡通</option>
                <option value="5">信用卡/簽帳金融卡</option>
                <option value="6">註銷載具-悠遊卡</option>
                <option value="7">註銷載具-icash</option>
                <option value="8">註銷載具-一卡通</option>
                <option value="9">註銷載具-信用卡/簽帳金融卡</option>
            </select>
        </div>
        <!--    選擇手機條碼-->
        <div id="cphone1" v-if="apoption === '0'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                手機號碼
            </label>
            <input class="rdiv" v-model="phonen">
        </div>
        <div id="cphone2" v-if="apoption === '0'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                驗證碼(密碼)
            </label>
            <input class="rdiv" v-model="testn">
        </div>
        <!--    選擇自然人憑證條碼-->
        <div class="radio" v-if="apoption === '1'"><label for="cnaturer1">
            <input type="radio" name="cnaturer" id="cnaturer1" value="1" v-model="cnaturer" checked>
            感應卡片
            <small> (需安裝使用晶片式讀卡機，以取得該票卡之卡號)</small>
        </label>
        </div>
        <div class="radio" v-if="apoption === '1'"><label for="cnaturer2">
            <input type="radio" name="cnaturer" id="cnaturer2" value="2" v-model="cnaturer">
            <span>輸入自然人憑證卡號和自然人憑證條碼密碼</span>
            <small> (請至超商多媒體機感應自然人憑證，以取得該票卡之自然人憑證卡號及自然人憑證條碼密碼)</small>
        </label>
        </div>
        <!--    選擇自然人憑證條碼 >> 感應卡片 -->
        <div v-if="cnaturer === '1' && apoption === '1'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                憑證PIN碼</label>
            <input class="rdiv">

        </div>
        <div v-if="cnaturer === '1' && apoption === '1'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                自然人憑證卡號</label>
            <input class="rdiv">

        </div>

        <!--    選擇自然人憑證條碼 >> 輸入卡號密碼 -->
        <div v-if="cnaturer === '2' && apoption === '1'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                自然人憑證卡號</label>
            <input disabled class="rdiv">

        </div>
        <div v-if="cnaturer === '2' && apoption === '1'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                自然人憑證條碼密碼</label>
            <input class="rdiv">

        </div>
        <!--    選擇悠遊卡-->
        <div class="radio" v-if="apoption === '2'"><label for="easy1">
            <input type="radio" name="easyew" value="1" id="easy1" v-model="easyew" checked>
            感應卡片
            <small> 讀卡元件僅能在Microsoft Internet Explorer上執行</small>
        </label>
        </div>
        <div class="radio" v-if="apoption === '2'"><label for="easy2">
            <input type="radio" name="easyew" value="2" id="easy2" v-model="easyew">
            輸入卡片內碼和卡片驗證碼
            <small> (請至超商多媒體機感應悠遊卡，以取得該票卡之卡片內碼及卡片驗證碼)</small>
        </label>
        </div>
        <!--    選擇悠遊卡 >> 感應卡片-->
        <div v-if="easyew === '1' && apoption === '2'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                載具隱碼</label>
            <input disabled class="rdiv">
        </div>
        <!--    選擇悠遊卡 >> 輸入卡片內碼及驗證碼-->
        <div v-if="easyew === '2' && apoption === '2'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片內碼</label>
            <input class="rdiv">
        </div>
        <div v-if="easyew === '2' && apoption === '2'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片驗證碼</label>
            <input class="rdiv">
        </div>
        <!--    選擇icash  -->
        <div class="radio" v-if="apoption === '3'">
            <label for="icash">
                <input type="radio" name="icash" value="1" id="icash" v-model="icash" checked>
                感應卡片
                <small> 讀卡元件僅能在Microsoft Internet Explorer上執行</small>
            </label>
        </div>
        <div v-if="apoption === '3'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                載具隱碼</label>
            <input disabled class="rdiv">
        </div>
        <!--    選擇一卡通-->
        <div class="radio" v-if="apoption === '4'"><label for="ipass1">
            <input type="radio" name="ipass" value="1" id="ipass1" v-model="ipass" checked>
            感應卡片
            <small> 讀卡元件僅能在Microsoft Internet Explorer上執行</small>
        </label>
        </div>
        <div class="radio" v-if="apoption === '4'"><label for="ipass2">
            <input type="radio" name="ipass" value="2" id="ipass2" v-model="ipass">
            輸入卡片內碼和卡片驗證碼
            <small> (請至超商多媒體機感應一卡通，以取得該票卡之卡片內碼及卡片驗證碼)</small>
        </label>
        </div>
        <!--    選擇一卡通 >> 感應卡片-->
        <div v-if="ipass === '1' && apoption === '4'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                載具隱碼</label>
            <input disabled class="rdiv">
        </div>
        <!--    選擇一卡通 >> 輸入卡片內碼及驗證碼-->
        <div v-if="ipass === '2' && apoption === '4'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片內碼</label>
            <input class="rdiv">
        </div>
        <div v-if="ipass === '2' && apoption === '4'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片驗證碼</label>
            <input class="rdiv">
        </div>
        <!--    選擇信用卡/簽帳金融卡  -->
        <div v-if="apoption === '5'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                銀行別</label>
            <select id="bankNumber"
                    class="rdiv">
                <option value="" class="" selected="selected">選擇銀行別</option>
                <option value="004">004臺灣銀行</option>
                <option value="005">005臺灣土地銀行</option>
                <option value="006">006合作金庫商業銀行</option>
                <option value="007">007第一商業銀行</option>
                <option value="008">008華南商業銀行</option>
                <option value="009">009彰化商業銀行</option>
                <option value="011">011上海商業儲蓄銀行</option>
                <option value="012">012台北富邦商業銀行</option>
                <option value="013">013國泰世華商業銀行</option>
                <option value="016">016高雄銀行</option>
                <option value="017">017兆豐國際商業銀行</option>
                <option value="050">050臺灣中小企業銀行</option>
                <option value="053">053台中商業銀行總行</option>
                <option value="102">102華泰商業銀行</option>
                <option value="103">103臺灣新光商業銀行</option>
                <option value="108">108陽信商業銀行</option>
                <option value="147">147三信商業銀行</option>
                <option value="700">700中華郵政股份有限公司</option>
                <option value="803">803聯邦商業銀行</option>
                <option value="805">805遠東國際商業銀行</option>
                <option value="807">807永豐商業銀行</option>
                <option value="808">808玉山商業銀行</option>
                <option value="812">812台新國際商業銀行</option>
                <option value="815">815日盛國際商業銀行</option>
                <option value="822">822中國信託商業銀行</option>
            </select>
            <a class="btn btn-primary etooltip" target="_blank" title="信用卡存發票好康專區" copied="信用卡存發票好康專區"
               href="https://www.einvoice.nat.gov.tw/ein_upload/html/ESQ/ESQ501W.html#tab2" style="height: 29px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="27" fill="currentColor"
                     class="bi bi-info-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                    <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                </svg>
                <span class="glyphicon glyphicon-info-sign"></span>
            </a>
        </div>

        <div v-if="apoption === '5'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡號</label>
            <input class="rdiv">
        </div>
        <div v-if="apoption === '5'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                身分證末4碼</label>
            <input class="rdiv">
        </div>
        <div v-if="apoption === '5'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                生日4碼</label>
            <input class="rdiv">
        </div>
        <!--    註銷載具-悠遊卡  -->
        <div v-if="apoption === '6'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片內碼</label>
            <input class="rdiv">
        </div>
        <div v-if="apoption === '6'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片驗證碼</label>
            <input class="rdiv">
        </div>
        <!--    註銷載具-iCash  -->
        <div v-if="apoption === '7'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片內碼</label>
            <input class="rdiv">
        </div>
        <div v-if="apoption === '7'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片驗證碼</label>
            <input class="rdiv">
        </div>
        <!--    註銷載具-一卡通  -->
        <div v-if="apoption === '8'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片內碼</label>
            <input class="rdiv">
        </div>
        <div v-if="apoption === '8'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片驗證碼</label>
            <input class="rdiv">
        </div>
        <!--    註銷載具-信用卡/簽帳金融卡  -->
        <div v-if="apoption === '9'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡號</label>
            <input class="rdiv">
        </div>
        <div v-if="apoption === '9'">
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                卡片驗證碼</label>
            <input class="rdiv">
        </div>


        <div>
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                發票期別
            </label>
            <select class="rdiv" v-model="invoice">
                <option value="0">111年03-04月</option>
                <option value="1">111年01-02月</option>
                <option value="2">110年11-12月</option>
            </select>
        </div>
        <div>
            <label class="col-sm-3 control-label" style="text-align:right">
                <span class="redstar">*</span>
                圖形驗證碼
            </label>
            <input class="rdiv" v-model="pic">
            <image-code :change="data.change_img_code" @click="changeImageCode" @getCode="backImageCode"
                        style="display: inline-block"></image-code>
        </div>
        <div style="margin-left: 18%; margin-top: 5%">
            <button class="cbutton">查詢</button>
            <button class="cbutton" @click="empty()">清除</button>
        </div>
    </div>
    <div class="sbox">
        說明事項
        <br>
        <div style="margin-left:20px">
            1.載具歸戶後提供自動對獎服務，透過電子郵件寄送中獎訊息。<br>
            2.綁定金融帳戶，中獎獎金自動匯款，便捷省時又環保。 <br>
            3.各期中獎統一發票將於開獎月28日18:00起開放查詢(實際開放時間將因當期發票量提前或延後)，並於開獎次月6日開放至超商多媒體服務機(KIOSK) 列印。
        </div>
    </div>

</template>

<script setup>

    import {
        ref,
        reactive,
    } from 'vue';

    import imageCode from '../apconsumer/testImage.vue';

    const apoption = ref(0);
    const cnaturer = ref(1);
    const easyew = ref(1);
    const ipass = ref(1);
    const invoice = ref(0);
    const pic = ref();
    const phonen = ref();
    const testn = ref();


    function empty() {
        this.apoption = '0';
        this.cnaturer = '';
        this.easyew = '';
        this.ipass = '';
        this.invoice = '0';
        this.pic = '';
        this.phonen = '';
        this.testn = '';
    }

    const data = reactive({
        change_img_code: false, // 刷新验证码
        img_code: '',// 加密后的验证码值
    })

    // 刷新验证码操作
    const changeImageCode = () => {
        data.change_img_code = !data.change_img_code
    }

    // 接收组件返回加密后的验证码值
    const backImageCode = (code) => {
        data.img_code = code
        console.log('data', data.img_code)
    }


</script>
<style scoped>

</style>