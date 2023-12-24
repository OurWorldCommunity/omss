/**

Copyright (c) 2023 by Ana Tudor (https://codepen.io/thebabydino/pen/rNPOpJK)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


*/
<template>

<svg width="0" height="0">
  <filter id="f" x="-50%" y="-200%" width="200%" height="500%">
    <feGaussianBlur stdDeviation="35"></feGaussianBlur>
    <feColorMatrix type="saturate" values="1.3"></feColorMatrix>
    <feComposite in="SourceGraphic"></feComposite>
  </filter>
</svg>
<h1>OurWorld Community Minecraft Skin System</h1>
</template>
<style scoped>
@property --k {
  syntax: "<number>";
  initial-value: 0;
  inherits: false;
}
html, body {
  display: grid;
}

html {
  height: 100%;
}

body {
  background: #000;
}

svg[height="0"] {
  position: absolute;
}

h1 {
  margin: 0.2em 0.5em;
  /* no pseudo needed */
  --k: 0;
  place-self: center;
  background: linear-gradient(90deg, hsl(calc(var(--k)*1turn), 95%, 65%), hsl(calc(var(--k)*1turn + 90deg), 95%, 65%));
  -webkit-background-clip: text;
  background-clip: text;
  color: transparent;
  font: 900 clamp(.875em, 2em, 5em) arial black, sans-serif;
  filter: url(#f);
  text-align: center;
/*  text-transform: uppercase; */
  /* needs support for animating custom properties */
  /* Firefox not quite there yet, but it's coming */
  animation: k 4s linear infinite;
}

@keyframes k {
  to {
    --k: 1 ;
  }
}
</style>