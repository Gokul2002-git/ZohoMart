//remove from cart
function removefromcart(productid){
    // alert("remove");
    data={
        "id":productid
    };
    $.ajax({
        url:"removefromcart",
        type:"POST",
        data:data,
        success:function(res){
            alert("Item succesfully removed");
            window.location.replace("Cart");

        }

    });
}
// to load home page
function onloadhome(){
    window.location.replace("User");
}