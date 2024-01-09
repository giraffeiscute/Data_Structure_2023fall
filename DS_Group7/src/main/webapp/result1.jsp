<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>

<%
    // æ¨¡æ¬å¾å¤é¨æ¸ææºï¼ä¾å¦APIï¼ç²åçæç´¢çµæ
    HashMap<String, String> searchResults = (HashMap<String, String>) request.getAttribute("filteredList");
	// 獲取推薦電影列表
	ArrayList<String> recommendations = (ArrayList<String>) request.getAttribute("recommendations");

	// 檢查 keyword 是否為 null
	String keyword = request.getParameter("keyword");
	if (keyword != null) {
   		keyword = URLEncoder.encode(keyword, "UTF-8");
	}
%>

<%! 
//生成電影搜索的超連結
String generateMovieSearchLink(String movieTitle) {
    try {
        // 假設您的搜索鏈接格式已經包含完整的URL，只需要將電影名稱進行編碼
        String encodedTitle = URLEncoder.encode(movieTitle, "UTF-8");
        return "http://localhost:8080/DS_Group7/Main?keyword=" + movieTitle;
    } catch (Exception e) {
        e.printStackTrace();
        return "#"; // 錯誤時返回默認鏈接
    }
}
%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result</title>
    <link href="/Users/ys/Desktop/NCCU/è³æçµæ§/Final Project/DS_Project/dist/out.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body>
    <!-- tailwind.config.js -->
	
    <!-- component -->
    <div class="max-w-4xl px-10 py-6 mx-auto bg-white rounded-lg shadow-md">
        <h1 class="text-xl font-bold text-gray-700 mb-4">Search Results</h1>

        <!-- 顯示搜索結果 -->
        <% if (searchResults != null && !searchResults.isEmpty()) { %>
            <% for (String title : searchResults.keySet()) { %>
                <div class="mt-6">
                    <div class="mt-2">
                        <p class="text-gray-600">
                            <a href="<%= searchResults.get(title) %>" class="text-blue-500 hover:underline"><%= title %></a>
                        </p>
                    </div>
                </div>
            <% } %>
        <% } else { %>
            <p>No search results found.</p>
        <% } %>

    </div>
    
    <!-- 顯示推薦電影列表 -->
<div class="max-w-4xl px-10 py-6 mx-auto bg-white rounded-lg shadow-md">
    <% if (recommendations != null && !recommendations.isEmpty()) { %>
        <h2 class="text-lg font-bold text-gray-700 mb-2">Recommended Movies</h2>
        <ul>
            <% for (String movie : recommendations) { %>
                <li class="text-gray-600">
                    <%-- 將電影標題進行 URL 編碼 --%>
                    <% String encodedTitle = URLEncoder.encode(movie, "UTF-8"); %>
                    <%-- 生成超連結 --%>
                    <a href="<%= generateMovieSearchLink(encodedTitle) %>" class="text-blue-500 hover:underline"><%= movie %></a>
                </li>
            <% } %>
        </ul>
    
        <hr class="my-4">
    <% } else { %>
   		 <p>No recommended movies found.</p>
    <% } %>
    
</div>


</body>

</html>