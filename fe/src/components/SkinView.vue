<template>
    <div style="width:100%;height:100%">
<canvas id="skin_container"></canvas></div>
</template>
<script setup>
    import { SkinViewer } from 'skinview3d';
    import { onMounted , ref , watch } from 'vue';

	const props = defineProps(['skin_path']);
	let sv;

    onMounted(() => {
    	sv = new SkinViewer({
            canvas: document.getElementById("skin_container"),
            width: 300,
            height: 400,
            skin: props.skin_path
        });
    })

	watch(
		() => props.skin_path,
		(newProps) => {
			console.log("更新皮肤渲染地址 -> "+newProps);
			sv.loadSkin(newProps);
		}
	);
    
    


	// Change viewer size
	// sv.width = 600;
	// sv.height = 800;

	// Load another skin
//	sv.loadSkin("img/skin2.png");

	// Load a cape



	// Set the background color
	// skinViewer.background = 0x5a76f3;

	// // Set the background to a normal image
	// skinViewer.loadBackground("img/background.png");

	// // Set the background to a panoramic image
	// skinViewer.loadPanorama("img/panorama1.png");

	// // Change camera FOV
	// skinViewer.fov = 70;

	// // Zoom out
	// skinViewer.zoom = 0.5;

	// // Rotate the player
	// skinViewer.autoRotate = true;

	// // Apply an animation
	// skinViewer.animation = new skinview3d.WalkingAnimation();

	// // Set the speed of the animation
	// skinViewer.animation.speed = 3;

	// // Pause the animation
	// skinViewer.animation.paused = true;

	// // Remove the animation
	// skinViewer.animation = null;
</script>
