<template>
    <button>
        <div style="width:100%">
            <span>上传皮肤</span>  
            <iframe src="data:text/html;base64,PGh0bWw+CiAgICAgICAgICAgIDxoZWFkPgogICAgICAgICAgICAgICAgPG1ldGEgbmFtZT0idmlld3BvcnQiIGNvbnRlbnQ9IndpZHRoPWRldmljZS13aWR0aCwgaW5pdGlhbC1zY2FsZT0xIj4KICAgICAgICAgICAgICAgIDxzdHlsZT4KICAgICAgICAgICAgICAgICAgICBodG1sLCBib2R5LCBpZnJhbWUsIGNhbnZhc3sKICAgICAgICAgICAgICAgICAgICAgICAgbWFyZ2luOiAwOwogICAgICAgICAgICAgICAgICAgICAgICBwYWRkaW5nOiAwOwogICAgICAgICAgICAgICAgICAgICAgICB3aWR0aDogMTAwJTsKICAgICAgICAgICAgICAgICAgICAgICAgaGVpZ2h0OiAxMDAlOwogICAgICAgICAgICAgICAgICAgICAgICBib3JkZXI6IDA7CiAgICAgICAgICAgICAgICAgICAgfQogICAgICAgICAgICAgICAgPC9zdHlsZT4KICAgICAgICAgICAgICAgIDxzY3JpcHQgdHlwZT0ibW9kdWxlIj4KICAgICAgICAgICAgICAgICAgICBpbXBvcnQgUmVhY3QsIHt1c2VSZWZ9IGZyb20gJ2h0dHBzOi8vY2RuLnNreXBhY2suZGV2L3JlYWN0QDE4LjAuMic7CiAgICAgICAgICAgICAgICAgICAgaW1wb3J0IFJlYWN0RE9NIGZyb20gJ2h0dHBzOi8vY2RuLnNreXBhY2suZGV2L3JlYWN0LWRvbUAxOC4wLjInOwogICAgICAgICAgICAgICAgICAgIGltcG9ydCB7Q2FudmFzLCB1c2VGcmFtZX0gZnJvbSAnaHR0cHM6Ly9jZG4uc2t5cGFjay5kZXYvQHJlYWN0LXRocmVlL2ZpYmVyQDcuMC4yNCc7CgogICAgICAgICAgICAgICAgICAgIGNvbnN0IFRleHR1cmVNZXNoID0gKCkgPT4gewogICAgICAgICAgICAgICAgICAgICAgICBjb25zdCBtZXNoID0gdXNlUmVmKG51bGwpCiAgICAgICAgICAgICAgICAgICAgICAgIHVzZUZyYW1lKHN0YXRlID0+IHsKICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNvbnN0IHsgY2xvY2ssIG1vdXNlLCBnbCwgc2NlbmUsIGNhbWVyYSB9ID0gc3RhdGUKICAgICAgICAgICAgICAgICAgICAgICAgICAgIGlmKG1lc2guY3VycmVudCl7CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgbWVzaC5jdXJyZW50Lm1hdGVyaWFsLnVuaWZvcm1zLnVfbW91c2UudmFsdWUgPSBbbW91c2UueCwgbW91c2UueV0KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBtZXNoLmN1cnJlbnQubWF0ZXJpYWwudW5pZm9ybXMudV90aW1lLnZhbHVlID0gY2xvY2suZ2V0RWxhcHNlZFRpbWUoKQogICAgICAgICAgICAgICAgICAgICAgICAgICAgfQogICAgICAgICAgICAgICAgICAgICAgICB9KQogICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgcmV0dXJuIFJlYWN0LmNyZWF0ZUVsZW1lbnQoJ21lc2gnLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgewogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHJlZjptZXNoLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHBvc2l0aW9uOiBbMCwwLDBdLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHNjYWxlOiAxLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHJvdGF0aW9uOiBbMCwwLDBdCiAgICAgICAgICAgICAgICAgICAgICAgICAgICB9LAogICAgICAgICAgICAgICAgICAgICAgICAgICAgUmVhY3QuY3JlYXRlRWxlbWVudCgncGxhbmVHZW9tZXRyeScse2FyZ3M6WzEwMjQsMTAyNF19KSwgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICBSZWFjdC5jcmVhdGVFbGVtZW50KCdzaGFkZXJNYXRlcmlhbCcsewogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGZyYWdtZW50U2hhZGVyOiBgLy8gRnJhZ21lbnQgc2hhZGVyCgovLyBVbmlmb3Jtcwp1bmlmb3JtIHZlYzIgdV9yZXNvbHV0aW9uOwp1bmlmb3JtIHZlYzIgdV9tb3VzZTsKdW5pZm9ybSBmbG9hdCB1X3RpbWU7CnVuaWZvcm0gdmVjMyB1X2NvbG9yOwp1bmlmb3JtIGZsb2F0IHVfc2NhbGU7IAp1bmlmb3JtIGZsb2F0IHVfZGlzdG9ydF9zY2FsZTsKdW5pZm9ybSBmbG9hdCB1X3Bvd2VyOwp1bmlmb3JtIGZsb2F0IHVfc3BlZWQ7CnVuaWZvcm0gZmxvYXQgdV94Owp1bmlmb3JtIGZsb2F0IHVfeTsKdW5pZm9ybSBmbG9hdCB1X2l0ZXJhdGlvbnM7CiAgICAKI2RlZmluZSBwb3dlciAxLgojZGVmaW5lIHpvb21PdXQgMy4KI2RlZmluZSByb3QgMS4KI2RlZmluZSBpdGVyIDUwLgojZGVmaW5lIGh1ZVBvd2VyIDAuNwojZGVmaW5lIGdsb3cgMC41CiNkZWZpbmUgU3BlZWQgMS41CiNkZWZpbmUgV2F2ZVNwZWVkIDIuCiNkZWZpbmUgQnJpZ2h0bmVzcyAwLjUKCnZvaWQgbWFpbigpCnsKICAgIC8vIE5vcm1hbGl6ZWQgcGl4ZWwgY29vcmRpbmF0ZXMgKGZyb20gMCB0byAxKQogICAgdmVjMiB1diA9IGdsX0ZyYWdDb29yZC54eS91X3Jlc29sdXRpb24ueHk7CgoJdmVjMiBYWVNjYWxlID0gdmVjMigxLjAtdV9zY2FsZSwxLjAtdV9zY2FsZSk7Cgl2ZWMyIFhZTW92ZSA9IHZlYzIodV94LHVfeSk7CglmbG9hdCBpdGVyYXRpb25zID0gaXRlciAqIHVfaXRlcmF0aW9uczsKCiAgdXYgKj0gem9vbU91dDsKCXV2Lnh5ID0gdXYueHkgKiBYWVNjYWxlOwoJdXYueHkgPSB1di54eSArIFhZTW92ZTsKCXZlYzMgZmluYWxDb2wgPSB2ZWMzKDAsMCwwKTsKCWZsb2F0IGhhbGZEaXN0b3J0ID0gdV9kaXN0b3J0X3NjYWxlIC8gMC41OwoJZmxvYXQgZGlzdG9ydHNjMiA9IHVfZGlzdG9ydF9zY2FsZSAvIHVfZGlzdG9ydF9zY2FsZSArIGhhbGZEaXN0b3J0OwogICAgCglmb3IoZmxvYXQgaSA9IDEuMDsgaSA8IGl0ZXJhdGlvbnM7IGkrKyl7CgkJdXYueCArPSB1X3Bvd2VyIC8gaSAqIHNpbihpICogdV9kaXN0b3J0X3NjYWxlICogdXYueSAtICh1X3RpbWUgKiBTcGVlZCAqIHVfc3BlZWQpKTsKCQl1di55ICs9IHVfcG93ZXIgLyBpICogc2luKGkgKiBkaXN0b3J0c2MyICogdXYueCArICh1X3RpbWUgKiBTcGVlZCAqIHVfc3BlZWQpKTsKCX0KICAgIAoJdmVjMyBjb2wgPSB2ZWMzKHZlYzMoZ2xvdyxnbG93LGdsb3cpL3NpbigodV90aW1lKldhdmVTcGVlZCp1X3NwZWVkKS1sZW5ndGgodXYueXgpIC0gdXYueSkpOwoJZmluYWxDb2wgPSB2ZWMzKGNvbCpjb2wpOwogICAgdmVjMyBDb2xvciA9IHZlYzMoMS4sMS4sMS4pICogQnJpZ2h0bmVzczsKCQogICAgQ29sb3IgPSBDb2xvcipDb2xvciAqIDAuNSArIDAuNSpjb3MoKHVfdGltZSp1X3NwZWVkKSt1di54eXgrdmVjMygwLDIsNCkpICogaHVlUG93ZXI7CgoKICAgIC8vIE91dHB1dCB0byBzY3JlZW4KICAgIGdsX0ZyYWdDb2xvciA9IHZlYzQoZmluYWxDb2wucmdiICogQ29sb3IsIDEuMCkgKiBwb3dlcjsKfWAsCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgdmVydGV4U2hhZGVyOiBgLy8gVmVydGV4IHNoYWRlcgoKdm9pZCBtYWluKCkgewogIGdsX1Bvc2l0aW9uID0gcHJvamVjdGlvbk1hdHJpeCAqIG1vZGVsVmlld01hdHJpeCAqIHZlYzQocG9zaXRpb24sIDEuMCk7Cn1gLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHVuaWZvcm1zOiB7InVfY29sb3IiOnsidmFsdWUiOlsxLDAsMF19LCJ1X3NjYWxlIjp7InZhbHVlIjowLjIxfSwidV9kaXN0b3J0X3NjYWxlIjp7InZhbHVlIjowLjUzNX0sInVfcG93ZXIiOnsidmFsdWUiOjAuMTU3fSwidV9zcGVlZCI6eyJ2YWx1ZSI6MC4yMjJ9LCJ1X3giOnsidmFsdWUiOjAuNX0sInVfeSI6eyJ2YWx1ZSI6MC44NTl9LCJ1X2l0ZXJhdGlvbnMiOnsidmFsdWUiOjAuMTIyfSwidV90aW1lIjp7InZhbHVlIjowfSwidV9tb3VzZSI6eyJ2YWx1ZSI6WzAsMF19LCJ1X3Jlc29sdXRpb24iOnsidmFsdWUiOlsxMDI0LDEwMjRdfX0sCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgd2lyZWZyYW1lOiBmYWxzZSwgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgd2lyZWZyYW1lTGluZXdpZHRoOiAwLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGRpdGhlcmluZzogZmFsc2UsCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgZmxhdFNoYWRpbmc6IHRydWUsCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgZG91YmxlU2lkZWQ6IHRydWUsCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgZ2xzbFZlcnNpb246ICIxMDAiCiAgICAgICAgICAgICAgICAgICAgICAgICAgICB9KQogICAgICAgICAgICAgICAgICAgICAgICApOyAgCiAgICAgICAgICAgICAgICAgICAgfQoKICAgICAgICAgICAgICAgICAgICBSZWFjdERPTS5yZW5kZXIoUmVhY3QuY3JlYXRlRWxlbWVudChDYW52YXMsewogICAgICAgICAgICAgICAgICAgICAgICAgICAgZ2w6IHsKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBwcmVzZXJ2ZURyYXdpbmdCdWZmZXI6IHRydWUsCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgcHJlbXVsdGlwbGllZEFscGhhOiBmYWxzZSwKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBhbHBoYTogdHJ1ZSwKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB0cmFuc3BhcmVudDogdHJ1ZSwKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBhbnRpYWxpYXM6IHRydWUsCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgcHJlY2lzaW9uOiAiaGlnaHAiLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHBvd2VyUHJlZmVyZW5jZTogImhpZ2gtcGVyZm9ybWFuY2UiCiAgICAgICAgICAgICAgICAgICAgICAgICAgICB9LAogICAgICAgICAgICAgICAgICAgICAgICAgICAgZHByOiBbMiwyXSwKICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNhbWVyYTogewogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGZvdjogNzUsCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgbmVhcjogMC4xLAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGZhcjogMTAwMCwKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBwb3NpdGlvbjogWzAsMCw1XQogICAgICAgICAgICAgICAgICAgICAgICAgICAgfSwKICAgICAgICAgICAgICAgICAgICAgICAgICAgIHN0eWxlOnsgaGVpZ2h0OiA1MTIsIHdpZHRoOiA1MTIgfQogICAgICAgICAgICAgICAgICAgICAgICB9LAogICAgICAgICAgICAgICAgICAgICAgICBSZWFjdC5jcmVhdGVFbGVtZW50KFRleHR1cmVNZXNoKSAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICksIGRvY3VtZW50LmJvZHkpOwogICAgICAgICAgICAgICAgPC9zY3JpcHQ+CiAgICAgICAgICAgIDwvaGVhZD4KICAgICAgICAgICAgPGJvZHk+CjwhLS0gQVNTRVQgTk9UIElOTElORUQ6IGFzc2V0cy9seWdpYS5mNzQ5MDU5NC5zdmcgLS0+Cgo8IS0tIEFTU0VUIE5PVCBJTkxJTkVEOiBhc3NldHMvYWRkLmE1NTI0MGRkLnN2ZyAtLT4KCjwhLS0gQVNTRVQgTk9UIElOTElORUQ6IGFzc2V0cy9ib29rLjVmYjExYjhkLnN2ZyAtLT4KCjwhLS0gQVNTRVQgTk9UIElOTElORUQ6IGFzc2V0cy9jb2RlLjQyOGIxOGY1LnN2ZyAtLT4KCjwhLS0gQVNTRVQgTk9UIElOTElORUQ6IGFzc2V0cy9vdmVyZmxvdy44ZDUwNDE1ZC5zdmcgLS0+Cgo8IS0tIEFTU0VUIE5PVCBJTkxJTkVEOiBhc3NldHMvY2xvc2UuNjRiODBkMDAuc3ZnIC0tPgoKPCEtLSBBU1NFVCBOT1QgSU5MSU5FRDogYXNzZXRzL3RyYXNoLjUyNGRiY2QzLnN2ZyAtLT4KPC9ib2R5PgogICAgICAgIDwvaHRtbD4=" style="border:0;margin:0;width: 512px;height:512px;" />
        </div>
    </button>
</template>
<style scoped>
button{
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  appearance: none;
  border: 0;
  background: 0;
  position: relative;
  color: white;
  font-weight: 400;
  border-radius: 0.5rem;
  overflow: hidden;
  font-family: inherit;
  font-weight: 500;
}
button:after{
  content: '';
  position: absolute;
  inset:0;
  box-shadow: inset 0 0 0 2px rgba(255,255,255,1);
  border-radius: inherit;
  mix-blend-mode: overlay;
}
button iframe{
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%) scale(1.2) rotate(15deg);
  opacity: 0.25;
  filter: blur(5px);
  transition: all 0.5s ease-in-out;
}
button span{
  position: relative;
  z-index: 1;
  opacity: 0.75;
  color: white;
  transition: all 0.5s ease-in-out;
}
button:hover iframe{
  transform: translate(-50%,-50%) scale(0.5);
  opacity: 1;
  filter: blur(0);
}
button:hover span{
  opacity: 1;
}
/* The secret sauce that enables gradient rotation. NOTE: does not work in all browsers. https://caniuse.com/?search=%40property */
@property --border-angle-1 {
	syntax: "<angle>";
	inherits: true;
	initial-value: 0deg;
}

@property --border-angle-2 {
	syntax: "<angle>";
	inherits: true;
	initial-value: 90deg;
}

@property --border-angle-3 {
	syntax: "<angle>";
	inherits: true;
	initial-value: 180deg;
}


/* sRGB color. */
:root {
	--bright-blue: rgb(0, 100, 255);
	--bright-green: rgb(0, 255, 0);
	--bright-red: rgb(255, 0, 0);
	--background: black;
	--foreground: white;
	--border-size: 2px;
	--border-radius: 0.75em;
}

/* Display-P3 color, when supported. */
@supports (color: color(display-p3 1 1 1)) {
	:root {
		--bright-blue: color(display-p3 0 0.2 1);
		--bright-green: color(display-p3 0.4 1 0);
		--bright-red: color(display-p3 1 0 0);
	}
}

@keyframes rotateBackground {
	to { --border-angle-1: 360deg; }
}

@keyframes rotateBackground2 {
	to { --border-angle-2: -270deg; }
}

@keyframes rotateBackground3 {
	to { --border-angle-3: 540deg; }
}

button {
	--border-angle-1: 0deg;
	--border-angle-2: 90deg;
	--border-angle-3: 180deg;
	color: inherit;
	font-family: inherit;
	border: 0;
	padding: var(--border-size);
	display: flex;
	width: max-content;
	background-color: transparent;
	background-image: conic-gradient(
			from var(--border-angle-1) at 10% 15%,
			transparent,
			var(--bright-blue) 10%,
			transparent 30%,
			transparent
		),
		conic-gradient(
			from var(--border-angle-2) at 70% 60%,
			transparent,
			var(--bright-green) 10%,
			transparent 60%,
			transparent
		),
		conic-gradient(
			from var(--border-angle-3) at 50% 20%,
			transparent,
			var(--bright-red) 10%,
			transparent 50%,
			transparent
		);
	animation: 
		rotateBackground 3s linear infinite,
		rotateBackground2 8s linear infinite,
		rotateBackground3 13s linear infinite;
}

button div {
	background: var(--background); 
	padding: 1em 1.5em;
	border-radius: calc(var(--border-radius) - var(--border-size));
	color: var(--foreground);
}

</style>