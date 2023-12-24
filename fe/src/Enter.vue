<script setup>
import BackGround from './components/BackGround.vue'
import MainBox from './components/MainBox.vue'
import Title from './components/Title.vue'
import Line_1 from './components/Line_1.vue'
import Line_2 from './components/Line_2.vue'
import SkinView from './components/SkinView.vue'
import UpLoadButton from './components/UpLoadButton.vue'
import StatusMark from './components/StatusMark.vue'
import TipCard from './components/TipCard.vue'
import Footer from './components/Footer.vue'
import PlayerIdBox from './components/PlayerIdBox.vue'
</script>

<template>
<div style="width:100vw;height:100vh;display:flex;justify-content: center;align-items: center;background-color: #1d212b;">
    <MainBox style="margin-top:1.5rem">
        <br>
        <Title></Title>
        <Line_1></Line_1>
        <StatusMark style="margin:0 auto" :sil_flag="sil_flag"></StatusMark>
        <Line_1></Line_1>
        <div style="display:flex;justify-content: space-evenly;align-items: center;flex-flow: row-reverse wrap;flex-direction: row-reverse;flex-wrap: wrap;">
            <div id="skin_box" style="max-width:20rem">

                <SkinView style="width:100%;height:75%" :skin_path="skin_path"></SkinView>
                <UpLoadButton style="width:60%;min-width:6rem;height:20%;margin:0 auto" v-on:click="uploadFile"></UpLoadButton>
            </div>
                <TipCard style="margin:1rem;text-align: left;line-height:3em">
                    <PlayerIdBox style="margin:0 auto;">{{ player_id }}</PlayerIdBox>
                    <b>Tips：</b>
                    <p>1. 暂时不支持披风啦~</p>
                    <p>2. 皮肤应用完成前，请勿退出服务器！</p>
                    <p>3. 仍在测试中，发现问题联系<a href="mailto:i@smyhw.online">smyhw(i@smyhw.online)</a>！</p>
                </TipCard>
        </div>
        <Line_2></Line_2>
        <Footer></Footer>
    </MainBox>


    <BackGround style="width:100%;height:100%;position:fixed;top:0;left:0"></BackGround>
</div>

</template>

<script>
    import { ref,onMounted } from 'vue';
    import { get_session,alert_and_exit } from './js_libs/utils';

    const skin_path = ref("/b443b6a3a3ea9e4f.png");
    const player_id = ref("获取中...");
    const sil_flag = ref(false);

    function uploadFile() {
        console.log("上传皮肤文件...")
      // 创建一个<input type="file">元素
      var fileInput = document.createElement('input');
      fileInput.type = 'file';

      // 添加change事件处理程序
      fileInput.addEventListener('change', function(event) {
        var file = event.target.files[0]; // 获取选择的文件

        // 创建一个FormData对象，并将文件添加到其中
        var formData = new FormData();
        formData.append('file', file);

        // 创建一个XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 设置请求方法和URL
        xhr.open('POST', '/api/skin_file/set?session='+get_session(), true);

        // TODO 弹个框显示上传进度，不过似乎也没必要，皮肤文件就5kb的说
        // xhr.upload.addEventListener('progress', function(event) {
        //   if (event.lengthComputable) {
        //     var percentComplete = (event.loaded / event.total) * 100;
        //     console.log('上传进度：' + percentComplete + '%');
        //   }
        // });

        // 监听请求完成事件
        xhr.addEventListener('load', function(event) {
          if (xhr.status === 200) {
            console.log('上传成功');
            skin_path.value = "/api/skin_file/get/"+get_session()+".png";
          } else {
            console.log('上传失败');
          }
        });
        xhr.onreadystatechange = function() {
          if (xhr.readyState === 4 && xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            switch(response.Status){
              case -2:
                alert("文件大小超过理论极值，请使用标准皮肤！");
                break;
              case -10:
                alert("mineskin接口错误，请重试或报告管理员！")
                break;
              case -11:
                alert("数据请求错误，请重试或报告管理员！");
                break;
            }
          }
        };

        // 发送请求
        xhr.send(formData);
      });

      // 触发文件选择对话框
      fileInput.click();
    }

    fetch("/api/session?session="+get_session()).then(respone=>{
        if(!respone.ok){
          alert_and_exit("连接后台出错，请重试！");
        }
        respone.json().then(data => {
          player_id.value = data['PlayerId'];
          if(player_id.value === undefined){
            sil_flag.value = true;
            player_id.value = "会话无效！";
            alert_and_exit("无效会话，请从游戏服务器中使用/omss指令生成连接来访问！");
          }
          console.log("获取到玩家id -> "+player_id.value)
        })
      });

</script>
