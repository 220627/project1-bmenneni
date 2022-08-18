const url = "http://localhost:3000";

console.log(document.cookie)

document.getElementById("submitReimbButton").onclick = submitReimb
document.getElementById("getReimbursementsButton").onclick = getReimbs

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

let id = getCookie("user_id")
console.log(id)

async function submitReimb() {

    let amount = document.getElementById("reimbAmount").value

    let submitReimbDetails = {
        reimb_amount: amount,
        reimb_author: id
    }

    console.log(submitReimbDetails)

    let response = await fetch(url + "/reimbursements", {
        method: "POST",
        body: JSON.stringify(submitReimbDetails),
        credentials: "include"
    })

    console.log(response.status)
}

async function getReimbs() {
    let response = await fetch(url + "/reimbursements/all")
    console.log(response)
    if(response.status === 200) {

        let data = await response.json();
        console.log(data)

        for(let reimbursements of data) {
            let row = document.createElement("tr")
            let cell = document.createElement("td")
            cell.innerHTML = reimbursements.reimb_id
            //console.log(reimbursements.reimb_id)
            row.appendChild(cell)

            let cell2 = document.createElement("td")
            cell2.innerHTML = reimbursements.reimb_amount
            //console.log(reimbursements.reimb_amount)
            row.appendChild(cell2)

            let cell3 = document.createElement("td")
            cell3.innerHTML = reimbursements.reimb_status
            //console.log(reimbursements.reimb_status)
            row.appendChild(cell3)

            let cell4 = document.createElement("td")
            cell4.innerHTML = reimbursements.reimb_author
            //console.log(reimbursements.reimb_author)
            row.appendChild(cell4)

            document.getElementById("reimbursementBody").appendChild(row)

        }

    } else {
        alert("Something went wrong")
    }
}