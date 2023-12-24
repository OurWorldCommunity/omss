<template>
<div class="element element-2" style="color:white;padding:1.5em"><slot></slot></div>
</template>
<style scoped>
body {
  align-items: center;
  background: #FFB6C1;
  display: grid;
  grid-gap: 2rem;
  grid-template-columns: 200px;
  height: 100vh;
  justify-content: center;
  padding: 1rem;
}

.element {
  align-items: center;
  background: linear-gradient(-45deg, rgba(0,0,0,0.22), rgba(255,255,255,0.25));
  box-shadow: 12px 12px 16px 0 rgba(0, 0, 0, 0.25),
   -8px -8px 12px 0 rgba(255, 255, 255, 0.3);
  border-radius: 50px;
  justify-content: center;
  width: fit-content;
}

.element-1 {
  background: #FFC0CB;
}

.element-2 {
  background: linear-gradient(-45deg, rgba(0,0,0,0.22), rgba(255,255,255,0.25));
}

.element-3 {
  background: linear-gradient(135deg, rgba(0,0,0,0.22), rgba(255,255,255,0.25));
}

@media (min-width: 700px) {
  body {
    grid-template-columns: repeat(3, 200px);
  }
}

</style>