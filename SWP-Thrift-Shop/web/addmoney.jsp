<%-- 
    Document   : addmoney
    Created on : Oct 12, 2022, 4:30:41 PM
    Author     : Admiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body style="background-color: #eee;">
    <section>
        <div class="container py-5">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                        <div class="row">
                            <div class="col-sm-12">
                                <h5 class="text-warning">Amount: $${sessionScope.AMOUNT.amount}</h5>
                            </div>

                    </nav>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <h4>Deposit Money in Wallet</h4>
                            <form class="mt-3" action="MainController">
                                <div class="d-flex justify-content-center mb-3">
                                    <h3>$</h3><input  style="font-size: 20px;" name="addmoney" class="mb-0 border-0" type="number" required>
                                    <input  name="userID" value="${sessionScope.LOGIN_USER.ID}" type="hidden"/>          
                                    ${sessionScope.ERROR}
                                    ${sessionScope.SUCCESS}
                                </div>
                                <h5>Payment method</h5>
                                <div class="mt-3">
                                    <input type="radio" id="Momo" name="drone" value="Momo" checked>
                                    <label for="Momo">Momo</label>
                                </div>

                                <div class="mt-2 mb-3">
                                    <input type="radio" id="Viettel" name="drone" value="Viettel">
                                    <label for="Viettel">Viettel Money</label>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6 d-grid">
                                        <a class="btn btn-outline-danger" href="wallet.jsp">Cancel</a>
                                    </div>
                                    <div class="col-sm-6 d-grid">
                                        <input type="submit" name="action" value="Add Money" class="btn btn-success"   />
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>

</html>
