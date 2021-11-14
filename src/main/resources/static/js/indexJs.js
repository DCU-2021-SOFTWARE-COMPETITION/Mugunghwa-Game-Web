const body = document.querySelector("body");
const btn = document.querySelector("input");

console.dir(btn);
btn.addEventListener("mouseover", () => {
    body.classList.add("onmouse");
});
btn.addEventListener("mouseleave", () => {
    body.classList.remove("onmouse");
})