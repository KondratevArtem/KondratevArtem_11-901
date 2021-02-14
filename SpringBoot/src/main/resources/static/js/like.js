function countLike(like, likePost) {
    let count = like.count

    likePost.html(count);
}

function addLike(userId, postId, count, id){
    let data = {
        "userId" : userId,
        "postId" : postId,
        "count": count
    };
    $.ajax(
        {
            type: "POST",
            url: "/home",
            data: JSON.stringify(data),
            success: function (response) {
                countLike(response, $(id))
            },
            dataType: "json",
            contentType: "application/json"
        }
    );
}