export function alert_and_exit(msg){
    //TODO 更好的提示框，但是现在来不及了qwq
    alert(msg);
    window.close();
}

export function get_session(){
    return new URLSearchParams(window.location.search).get("session");
}