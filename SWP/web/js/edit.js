function checkPassword(checkpassword) {
    var password = document.getElementById('password').value;
    if (checkpassword.value != password) {
        document.getElementById('wrong_pass_alert').style.color = 'red';
        document.getElementById('wrong_pass_alert').innerHTML
                = '☒ Use same password! Confirm password does not match';
        document.getElementById('create').disabled = true;
        document.getElementById('create').style.opacity = (0.4);
    } else {
        document.getElementById('wrong_pass_alert').style.color = 'green';
        document.getElementById('wrong_pass_alert').innerHTML =
                '🗹 Password Matched';
        document.getElementById('create').disabled = false;
        document.getElementById('create').style.opacity = (1);
    }
}
function checkconfirmPassword(checkpassword) {
    var confirm_password = document.getElementById('confirm_password').value;
    if (checkpassword.value != confirm_password) {
        document.getElementById('wrong_pass_alert').style.color = 'red';
        document.getElementById('wrong_pass_alert').innerHTML
                = '☒ Use same password! Confirm password does not match';
        document.getElementById('create').disabled = true;
        document.getElementById('create').style.opacity = (0.4);
    } else {
        document.getElementById('wrong_pass_alert').style.color = 'green';
        document.getElementById('wrong_pass_alert').innerHTML =
                '🗹 Password Matched';
        document.getElementById('create').disabled = false;
        document.getElementById('create').style.opacity = (1);
    }
}

function checkPassword2(checkpassword) {
    var password = document.getElementById('password2').value;
    if (checkpassword.value != password) {
        document.getElementById('wrong_pass_alert2').style.color = 'red';
        document.getElementById('wrong_pass_alert2').innerHTML
                = '☒ Use same password! Confirm password does not match';
        document.getElementById('create2').disabled = true;
        document.getElementById('create2').style.opacity = (0.4);
    } else {
        document.getElementById('wrong_pass_alert2').style.color = 'green';
        document.getElementById('wrong_pass_alert2').innerHTML =
                '🗹 Password Matched';
        document.getElementById('create2').disabled = false;
        document.getElementById('create2').style.opacity = (1);
    }
}
function checkPasswordonpageshow() {
    var password = document.getElementById('password2').value;
    var confirm_password = document.getElementById('confirm_password2').value;
    if (confirm_password != password) {
        document.getElementById('wrong_pass_alert2').style.color = 'red';
        document.getElementById('wrong_pass_alert2').innerHTML
                = '☒ Use same password! Confirm password does not match';
        document.getElementById('create2').disabled = true;
        document.getElementById('create2').style.opacity = (0.4);
    } else {
        document.getElementById('wrong_pass_alert2').style.color = 'green';
        document.getElementById('wrong_pass_alert2').innerHTML =
                '🗹 Password Matched';
        document.getElementById('create2').disabled = false;
        document.getElementById('create2').style.opacity = (1);
    }
}

function checkConfirmPassword2(checkpassword) {
    var confirm_password = document.getElementById('confirm_password2').value;
    if (checkpassword.value != confirm_password) {
        document.getElementById('wrong_pass_alert2').style.color = 'red';
        document.getElementById('wrong_pass_alert2').innerHTML
                = '☒ Use same password! Confirm password does not match';
        document.getElementById('create2').disabled = true;
        document.getElementById('create2').style.opacity = (0.4);
    } else {
        document.getElementById('wrong_pass_alert2').style.color = 'green';
        document.getElementById('wrong_pass_alert2').innerHTML =
                '🗹 Password Matched';
        document.getElementById('create2').disabled = false;
        document.getElementById('create2').style.opacity = (1);
    }
}
// function validate_password() {

//     var pass = document.getElementById('pass').value;
//     var confirm_pass = document.getElementById('confirm_pass').value;
//     if (pass != confirm_pass) {
//         document.getElementById('wrong_pass_alert').style.color = 'red';
//         document.getElementById('wrong_pass_alert').innerHTML
//         = '☒ Use same password!';
//         document.getElementById('create').disabled = true;
//         document.getElementById('create').style.opacity = (0.4);
//     } else {
//         document.getElementById('wrong_pass_alert').style.color = 'green';
//         document.getElementById('wrong_pass_alert').innerHTML =
//             '🗹 Password Matched';
//         document.getElementById('create').disabled = false;
//         document.getElementById('create').style.opacity = (1);
//     }
// }
function wrong_pass_alert(msg) {
    if (document.getElementById('password').value != "" &&
            document.getElementById('confirm_password').value != ""
            && document.getElementById('first_name').value != ""
            && document.getElementById('last_name').value != ""
            && document.getElementById('email').value != ""
            && document.getElementById('username').value != ""
            && document.getElementById('profile_id').value != ""
            && document.getElementById('hire_date').value != ""
            && document.getElementById('ReportsTo').value != ""
            && document.getElementById('department_id').value != ""
            && document.getElementById('job_id').value != "") {
        alert(msg);
    } else {
        alert("Please fill all the fields!");
    }
}

function wrongpassalert2(msg) {
    if (document.getElementById('password2').value != "" &&
            document.getElementById('confirm_password2').value != ""
            && document.getElementById('first_name2').value != ""
            && document.getElementById('last_name2').value != ""
            && document.getElementById('email2').value != ""
            && document.getElementById('username2').value != ""
            && document.getElementById('profile_id2').value != ""
            && document.getElementById('hire_date2').value != ""
            && document.getElementById('ReportsTo2').value != ""
            && document.getElementById('department_id2').value != ""
            && document.getElementById('job_id2').value != "") {
        alert(msg);
    } else {
        alert("Please fill all the fields");
    }
}


