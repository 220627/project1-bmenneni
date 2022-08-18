const url = "http://localhost:3000";

//add an event listener to give buttons some functionality (DOM Selection)

document.getElementById("getReimbursementButton").onclick = getReimbursements
document.getElementById("loginButton").onclick = loginFunction
//document.getElementById("updateButton").onclick = updateReimbStatus

async function getReimbursements(){

    let response = await fetch(url + "/reimbursements/all")

    console.log(response)

    if(response.status === 200) {

        let data = await response.json();
        for (let reimbursement of data) {
            let row = document.createElement("tr")
            let cell = document.createElement("td")
            cell.innerHTML = reimbursement.reimb_id
            row.appendChild(cell)

            let cell2 = document.createElement("td")
            cell.innerHTML = reimbursement.reimb_amount
            row.appendChild(cell2)

            let cell3 = document.createElement("td")
            cell.innerHTML = reimbursement.reimb_status
            row.appendChild(cell3)

            let cell4 = document.createElement("td")
            cell.innerHTML = reimbursement.reimb_author
            row.appendChild(cell4)

            document.getElementById("reimbursementBody").appendChild(row)
        }

    } else {
        alert('Something went wrong!')
    }    
} //end of getReimbursements()

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

        document.getElementById("loginRow").innerText = "Welcome " + data.username;

        //THIS IS PROBABLY WWHERE YOUR REDIRECT WOULD GO IF USING MULTIPLE HTML PAGES
        //check the users role id and use some control flow to determine what page gets rendered
    } else {
        //the header will change if the login fails
        document.getElementById("welcomeHead").innerText="Login Failed!";
        document.getElementById("welcomeHead").style.color = "red";
    }

}