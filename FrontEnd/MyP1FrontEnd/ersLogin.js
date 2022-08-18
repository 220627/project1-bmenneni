const url = "http://localhost:3000";

function setCookie(cname, cvalue) {
    document.cookie = cname + "=" + cvalue;
}

document.getElementById("loginButton").onclick = loginFunction

async function loginFunction() {

    let user = document.getElementById("username").value
    let pass = document.getElementById("password").value
    
    let userCreds = {
        username: user,
        password: pass
    }

    console.log(userCreds)

    let response = await fetch(url + "/login", {
        method: "POST",
        body: JSON.stringify(userCreds),
        credentials: "include"
    })
    
    console.log(response.status) 

    if(response.status === 202) {

        let data = await response.json();

        console.log(data)

        if(data.role_id_fk === 1) {
            window.open("http://localhost:5500/MyP1FrontEnd/ersEmployee.html"),
            document.getElementById("loginRow").innerText = "Welcome, " + data.user_first_name + "! You are now logged in as an Employee.";
        } else {
            window.open("http://localhost:5500/MyP1FrontEnd/ersManager.html"),
            document.getElementById("loginRow").innerText = "Welcome, " + data.user_first_name + "! You are now logged in as a Manager.";
        }

        setCookie("user_id", data.user_id)
        console.log(document.cookie);
        

    } else {
        document.getElementById("welcomeHead").innerText="Login Failed!";
        document.getElementById("welcomeHead").style.color = "red";
    }

}