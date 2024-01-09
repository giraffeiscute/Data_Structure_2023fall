<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search</title>
    <link href="../dist/out.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body>
    <div>
        <div class="h-screen flex justify-center items-center bg-cover bg-center"
            style="background-image: linear-gradient(rgb(0 0 0 / 60%), rgb(0 0 0 / 60%)), url('https://assets.nflxext.com/ffe/siteui/vlv3/c0a32732-b033-43b3-be2a-8fee037a6146/2fe6e3c0-5613-4625-a0c1-3d605effd10b/IN-en-20210607-popsignuptwoweeks-perspective_alpha_website_large.jpg')">
            <div class="absolute top-0 left-0 mt-5 ml-5">
                <svg viewBox="0 0 111 30" fill="#e50914" class="w-28" focusable="false">
                    
                </svg>
            </div>
      
            <div class="space-y-5">
                <p class="text-white font-bold text-5xl flex flex-col items-center">
                    <span>The Best <br /></span>
                    <span> MOVIE REVIEW SEARCH ENGINE </span>
                </p>
                <p class="text-white font-semibold text-3xl flex flex-col items-center">Search anywhere. Enjoy anytime.
                </p>
                <p class="text-white text-lg flex flex-col items-center">Ready to watch? Enter your keywords and find
                    the post or movie you want!</p>

                <!--ä»¥ä¸ä¸²å¾ç«¯é
è¦æ¹çå
°æ¹-->

                <div class="flex flex-row items-center justify-center">
        <form id="searchForm" action="/DS_Group7/Main" method="GET" class="flex">
            <input type="text" name="keyword" placeholder="Keywords" class="p-4 focus:outline-none focus:ring-1 focus:ring-blue-300" />
            <button type="submit" class="p-4 text-l font-semibold bg-red-600 hover:bg-red-700 text-white">Search></button>
        </form>
    </div>


                <!--ä»¥ä¸ä¸²å¾ç«¯é
è¦æ¹çå
°æ¹-->

            </div>
        </div>
        <hr />

    </div>
</body>

</html>