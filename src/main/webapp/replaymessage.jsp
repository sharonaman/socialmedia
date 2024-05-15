<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
    String id=(String) session.getAttribute("id");
    String uname=(String) session.getAttribute("name");
    String rid=(String) session.getAttribute("rid");
    String rname=(String) session.getAttribute("rname");
    String mid=(String) session.getAttribute("mid");
    %>
<div class="header_section">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="logo"><a href="index.html"><img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxAOEA4PEBAQDRANDw0QDQ8ODQ8NDRANFREWFhURExUYHSggGB4lHRYVITEhJSkrLi4uFx8zODMsNygtLisBCgoKDg0OGxAQGi0dICUrLS01Ny0yKystLSstLSstLS0tLS0vLS0tLS0tLS0tLS0tLS0tLS0rLS0tLS0tLS0tLf/AABEIAMgAyAMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAABgcDBAUBAgj/xAA9EAACAgADBQQFCwMEAwAAAAAAAQIDBAURBhIhMVETQXGBIlJhkZMHFCMyQmKSobHB0RZyghUkU+EXQ2P/xAAaAQEAAwEBAQAAAAAAAAAAAAAAAgQFAwEG/8QALREAAgICAAUCBQMFAAAAAAAAAAECAwQRBRIhMUFRkRMiYXHhMqGxBiNCwdH/2gAMAwEAAhEDEQA/ALxAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPD5nNJNvglxbfccPG5vJ8KYvTlvtfojjbdGtbbJwrlN6R2bb4wWspKK6t6GjZnmHj9vX+2LZGboWTeslKTfe+Jhlh5+q/cUZZ7b+WJoV4ENfNIk72jw/wB/4Z8PabD/AP08qyLSpl6r9xhmvILMn9CxHh1L8v3/AASx7WYZf8vwpGOW2WEXfb8KRE5GKR0jlyfdHZcLp+vv+CXPbbB9bfhSPP64wfW34UiGTguifkYZ4ePqr3HWOTvujouE479ff8E5/rjB9bfhSH9cYPrb8KRAZYWPTTwZilhl1fvJq/ZNcHx35fv+Cw/64wfW34UjHbt7goLi7ePDhTIr2WH9r9xz8bXq0k09PZ9o61zUnpklwWh+X7/gs3/yHget3wZEshLVJrk0mUlszkcsXiaq9NYRkp3NclWn+/LzLuitNDtJJdjG4ljU481Ctvfn/R9gAgZwAAAAAAAAB4eNnpxNps4rwdM7LZbsYrWWnGT6Qiu9t8CEm/C2yUYtvSPcwxievFRrjxbb0XDvb6ELzT5RMtw7ce1liJLmsPX2i/G9F+ZW21W0+IzGTU5OqhP6PDwl6HjN/bl+XQ1NltmLczxEaKlupLW61rehVX1fV9F3ssw4LuLtyZa+i8FzfJHoWBh/lRounGqnBYy6cnpCFaqnOXgkyY5b86xCTngrMKpcfp76d78MNWdLZbZbC5XX2eHrSk0u1uktbrJdZS6excEd8pWYuPvUE9fc4vIl4OBLJbOsPD0jUvyia13t1rrpqiU6HuhwswotfK9P3JLLtXkgeJymSTcXFtco9fA485aNpprR6NNciwsfgd5OUOElxaXf/wBkUzLD7+slwnHn7Y/yV8et12cl62n2aKmXxTNrjutr2RxJSMbZvQMsYJ9yfijSlRVHx+5mR/qPPf8AkvZHKZhte6m+Z31hoP7EfJGjmGGr4RSa04y0lL8J5WqZS1pk3/UfEYrfMvZHEsub5cPaSLKNh53wrtlcoQsipJRg3Zo/HgaOAyXt7I1w3lq/SfNRh3tlqYelVxjBcIwSUfBLQszhCKXKaGBxzPuTc5LX2Rp5PlFWDh2dUdE+MpPjKT6t950gCBKUpSblJ7bPQAeHgAAAAAAAAB4UV8qGdPFYuVEXrVhW4pJ8JXcpy8uS8y7cdd2ddln/ABwnL3LX9j85KLm5WS1bnJybfrPi3+Zp8LoVljm/H8lvFr5m2aEMLy11fsRf+wez8cvwkK91K2xRsxD04u1rl4JcPeVLstgldjsJW1qndCTXVQ9N/oX9E78Xs1y1r7nuXqOoo+gR7NdrcLhbexm7JSW72nZVSsVevrv9lqzrPH1dl2+/HsdztO019Dc013jF0Utm2CP5TtZhcVZ2MHOM3vbnaVSrVmnqP9nozYzvP6MEo9q5OVmu5CEN+bS5v2LxGmNnW0I9nuD3Zb64Kf1kl9s6mVZpVi61bVLWLejTWk4vpJdzMWex1pm/U0kvI9jCMpJSXQ4ZUd1P6dSvszunTY0ob6aUk1PTn7DU/wBalHnVp/nL+DdzeWu6/FHImb9eDTKC3H+T5Nzak9H1jtp5VxTVa9J6fX4/odvYnD/6nC22alTGuxQSi9/f9HV8WuHNEWeE+cTjXGHaSb0ikuLfsLa2UyWOAw0KVprq52NPXWx8/JcF5FTNpophqC1JmrgUq17ktpG9l+XVYeO7XHTq3xlLxZunh6ZZuxiorSWkegA8JAAAAAAAAAAAAGhnUdcNiIr7VFqX4GUIq+EV0UT9DWLVNPvXEovMMI6bba3w7Oycfc/4Nrg8180fsaOA11Rn2KkoZhhG++yUf8nBou8oPD2SqnC2P1q5wnHxT1/YvPLsXG6qu2HGNkYyj4MhxetqcZeGtEc6GpJkPzvZS2zEWWVpTjbJy1copxb5p6nfeSf7H5nvcez03u7f13vdqdsGS5Mz9Ig2R7K214iu2xKEapb3CUW5NcktDe2s2fsxU4W16TcYbkot6PTebTWviSwDme9nnKtaODsrk8sJXNT03rJbzSeqjotF5mTavFww+DxNs3uwhXJyfml7zslb/LJmSWHqwafpXzVtqT5U18vfLT8LO2NB2WxS9SUa+f5PUrfMNt7pyfZ1Vxin6KnvTn56NHW2AxFma435vetypU22SdSlB7y0S4vXqRVV6cuBZvyLYB7+LxL5RjCmD6tvfn+kD6HM/tUNxej2zhWPXHfKiwspyLD4TXsYJSa0c296x+bOqAfMSlKT23tkIwjFaitI9AB4SAAAAAAAAAAAAAAAPCtPlByrs7o4iK9G9aSa7rEv3X6Mss5+b5bHFVTqlwUlwffGXdJeBYxb/g2qXjydse34c0/BSsoEt2G2iWHfza56VTetc3yhN80+if5PxOHmGAnRZKqxaSg9PY13NexmnKB9JbXDIr0+z7G3ZXG2H0ZeiYKpyLay/CJQl9PUuCjJ6SivuS6exkxwe2uDmvSm6X0si1+a1R89dg21vtteqMe3Esg+20SYHCntXgYrV4mvT2NyfuSOHmvyh0wTWHhK6XdKa7OtfuznDFtm9KLOUabJPSRJ87zerBVSuteiXCKX1pT7oRXUonPcxsxt9l9vBzekYrlCC5QXgv3N3OMzvxk3ZdPea4RS4QgukF3HNcDfwcJULml1k/2NKjG+GtvuaXZNtJJtyeiS5uXci/djMn+Y4Omlpb+m/c133S4v3cF5EG+TbZntbFjbY/R1P/bpr69nr+C/XwLW0M/imSpyVcX0Xf7lXLsTfKvB6ADJKYAAAAAAAAAAAAAAAAAAAABxM/yKvGQ0foWR+pYlxXsfVFcZnlVuGluWRa1+rJcYT8GXCYMVhYWxcZxjOL5qUdUXcXNnT0fVFvHypVdH1RSsoHxKBYmY7E1y1lVN1fdku0h/K/MhmZYHsLJV78bHHhJwbaT9Xj3m5RmV39I9zWqyIW9F3OVKBilA3ZQPhVNtJJtyeiSWrci1vR0aNGUCQ7JbKSxslZYnDDxfF8nY/Uh7OrO5s7sQ5uNmLTjHnGjXjL+99y9hYFNUYJRilGKWkUlokjIzeJJJwrfX1/4ZuTlr9MPc8w9Ma4xhBKMYpKMUtEku4zAGGZgAAAAAAAAAAAAAAAAAAAAAAAAAMV9e/GUVJwclpvR5r2oAiu1m0fZJ0UP6RrSya/8AWui+9+hB64Sm9IxlOT7oqU2yx6Nk8JF6yg7W3q3ZOU9WdfD4SupaVwjWukIpGlVmVUR1XHb8tmhVl10w1CO36lf5bsjiLtHZ9BD73pWPy7vMmGUZBRheMIb09ONk/Ssf8eR19AVr8y239T6eiK9uVZb0b6eh9AArFcAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA//Z"></a></div><br><br>
        
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          
              <form action="Controller" method="post">
              <input type="hidden" name="id" value="<%= id %>">
              <input type="hidden" name="uname" value="<%= uname %>">
              <input type="hidden" name="action" value="userHome">
              <button type="submit">HOME</button>
              </form>
           
         </div>
      </nav>
</div>
<br><br>
<div class="center">
<form action="Controller" method="post">
<input type="hidden" name="id" value="<%= id %>">
<input type="hidden" name="uname" value="<%= uname %>">
<input type="hidden" name="rid" value="<%= rid %>">
<input type="hidden" name="rname" value="<%= rname %>">
<input type="hidden" name="mid" value="<%= mid %>">
<input type="text" style="height:150px;width:500px;" name="messages" placeholder="Enter message here...">
<button type="submit">send</button>
<input type="hidden" name="action" value="replymessagesend">
</form>
</div>

</body>
</html>
