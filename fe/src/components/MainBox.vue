<template>
    <div style="position:relative;width:90%;max-width:50rem;">
        <div id="b1" style="position:relative;right:0;top:0;height:100%;width:100%;z-index:2;border-radius: 1em;padding:1em">
            <slot></slot>
        </div>
        <div id="b2" style="position:absolute;right:0;top:0;height:100%;width:100%;z-index:1;"></div>
    </div>
</template>
<style scoped>
    #b1 {
        position: relative;
        text-align: center;
        color: #252B37;
        background-color: #151823;
 /*       animation: textColor 10s ease infinite; */
    }
    #b2 {
        position: absolute;
        top: 5vw;
        left: 0;
        right: 0;
        z-index: -1;
        height: 100%;
        width: 100%;
        margin: 0 auto;
        -webkit-filter: blur(5vw);
        -moz-filter: blur(5vw);
        -ms-filter: blur(5vw);
        filter: blur(5vw);
        background: linear-gradient(270deg, #0fffc1, #7e0fff);
        background-size: 200% 200%;
        animation: animateGlow 10s ease infinite;
    }


    @keyframes textColor {
        0% {
            color: #7e0fff;
        }
        50% {
            color: #0fffc1;
        }
        100% {
            color: #7e0fff;
        }
    }

</style>