export function set_cookie(cookieName, cookieValue) {
    document.cookie = cookieName + "=" + encodeURIComponent(cookieValue) + ";path=/";
}

export function getCookieValue(cookieName) {
    var cookieString = document.cookie;
    var cookies = cookieString.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i].trim();
        var cookiePair = cookie.split("=");

        if (cookiePair[0] === cookieName) {
            return decodeURIComponent(cookiePair[1]);
        }
    }

    return "";
}