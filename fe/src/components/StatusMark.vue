/**

Copyright (c) 2023 by Jason Lengstorf (https://codepen.io/jlengstorf/pen/WNPZrRv)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


*/
<template>
        <div><p style="position: relative;color: #afafaf;z-index: 15;width: 100%;height: 100%;display: grid;align-items: center;">{{ status_str }}</p></div>
</template>
<style scoped>
@property --gradient-angle {
	inherits: false;
	initial-value: 0deg;
	syntax: "<angle>";
}

@keyframes spin {
	to {
		--gradient-angle: 360deg;
	}
}
div {
    --black: oklch(17.7% 0.105 262.48);
	--purple: oklch(60% 0.37 294.7);
	--orange: oklch(60% 0.37 64.65);
	--yellow: oklch(60% 0.37 109.08);
	--blue: oklch(60% 0.37 237.06);
	--black-alpha-50: color-mix(in oklch, var(--black), transparent);
	animation: spin 2s linear infinite;
	background: linear-gradient(to bottom, var(--black), var(--black)) padding-box,
		conic-gradient(
				in oklch from var(--gradient-angle),
				var(--purple),
				var(--orange),
				var(--yellow),
				var(--blue),
				var(--purple)
			)
			border-box;
	border: 2.5px solid transparent;
	border-radius: 10px;
	position: relative;
	width: 9em;
	height: 3em;
	z-index: 10;

	&::before {
		background: black;
		border-radius: 15px;
		content: "";
		position: absolute;
		inset: 0;
		z-index: 5;
	}

	&::after {
        --black: oklch(17.7% 0.105 262.48);
        --purple: oklch(60% 0.37 294.7);
        --orange: oklch(60% 0.37 64.65);
        --yellow: oklch(60% 0.37 109.08);
        --blue: oklch(60% 0.37 237.06);
        --black-alpha-50: color-mix(in oklch, var(--black), transparent);
		animation: spin 2s linear infinite;
		background: conic-gradient(
			in oklch from var(--gradient-angle),
			var(--purple),
			var(--orange),
			var(--yellow),
			var(--blue),
			var(--purple)
		);
		border-radius: 15px;
		content: "";
		position: absolute;
		inset: 0;
		filter: blur(50px);
		z-index: 1;
	}
}

</style>
<script setup>
import { ref , onMounted } from 'vue'
import { get_session,alert_and_exit } from '../js_libs/utils';


const status_str = ref('等待上传...')

const props = defineProps(['sil_flag']);


onMounted(() => {
	setInterval(function() {
//		console.log("更新状态...");
		fetch("/api/session?session="+get_session())
		.then(respone=>{
			if(respone.ok){
				respone.json().then(data => {
					let api_status = data['Status']
					switch (api_status) {
						case 1:
							status_str.value = "等待上传..."
							break;
						case 2:
							status_str.value = "应用中..."
							break;
						case 3:
							status_str.value = "完成！"
							props.sil_flag = true;
							break;
						case -1:
							status_str.value = "会话失效！"
							if(!props.sil_flag){
								props.sil_flag = true;
								alert_and_exit("会话失效，在皮肤应用完成前请勿退出游戏服务器！");
							}
							break;
						default:
							status_str.value = "状态异常("+api_status+")"
							console.log("状态异常("+api_status+")");
					}
				})
			}
		})
		.catch(function(error) {
			status_str.value = "状态异常("+error+")"
    		console.log('Error:', error);
		});
	}, 1000);
})


</script>