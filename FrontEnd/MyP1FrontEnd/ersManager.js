const url = "http://localhost:3000";

console.log(document.cookie)

document.getElementById("getAllReimbsButton").onclick = getAllReimbs

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

async function getAllReimbs() {
    let response = await fetch(url + "/reimbursements/all")
    console.log(response)
    if(response.status === 200) {

        let data = await response.json();
        for(let reimbursements of data) {
            let row = document.createElement("tr")
            let cell = document.createElement("td")
            cell.innerHTML = reimbursements.reimb_id
            row.appendChild(cell)

            let cell2 = document.createElement("td")
            cell.innerHTML = reimbursements.reimb_amount
            row.appendChild(cell2)

            let cell3 = document.createElement("td")
            cell.innerHTML = reimbursements.reimb_status
            row.appendChild(cell3)

            let cell4 = document.createElement("td")
            cell.innerHTML = reimbursements.reimb_author
            row.appendChild(cell4)

            document.getElementById("allReimbsBody").appendChild(row)

        }

    } else {
        alert("Something went wrong")
    }
}

