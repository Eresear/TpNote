<%--
  Created by IntelliJ IDEA.
  User: yangyang
  Date: 2020/4/9
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@600&display=swap" rel="stylesheet">"

<style>
    .entry:not(:first-of-type)
    {
        margin-top: 10px;
    }

    .glyphicon
    {
        font-size: 12px;
    }
    body {
        font-family: 'Raleway', sans-serif;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>

    <div class="modal" tabindex="-1" role="dialog" id="modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Inserer une offre</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <form style="width: auto;">
                            <input style="margin-bottom: 10px" type="text" placeholder="Lieu de destination" style="min-width: 100%">

                            <textarea placeholder= "Description" style="min-width: 100%"></textarea>


                            <input style="margin-top: 10px" style="margin-bottom: 10px" type="number" name="tarif" placeholder="Tarif" style="min-width: 100%">
                    </form>


                    <div class="control-group" id="Chosesfields">
                        <div class="controls">

                            <form role="form" autocomplete="off">
                                <div class="entry input-group col-xs-3">
                                    <input style="margin-bottom: 10px" class="form-control" name="Chosesfields[]" type="text" placeholder="Choses à faire" />
                                    <span class="input-group-btn">
                                        <button style="margin-bottom: 10px" class="btn btn-success btn-chose-add "  type="button">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </span>
                                </div>
                            </form>


                            <br>
                        </div>
                    </div>

                    <div class="control-group" id="Activitefields">
                        <div class="controls">

                            <form role="form" autocomplete="off">
                                <div class="entry input-group col-xs-3">
                                    <input style="margin-bottom: 10px" class="form-control" name="Activitefields[]" type="text" placeholder="Les activités possible" />
                                    <span class="input-group-btn">
                                        <button style="margin-bottom: 10px" class="btn btn-success btn-act-add " type="button">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </span>
                                </div>
                            </form>


                            <br>
                        </div>
                    </div>





                </div>
                <div class="modal-footer">
                    <button style="margin-bottom: 10px" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button style="margin-bottom: 10px" type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>


</html>


<script type="text/javascript">
    $(function()
    {
        $(document).on('click', '.btn-chose-add', function(e)
        {
            e.preventDefault();

            var controlForm = $('#Chosesfields .controls form:first'),
                currentEntry = $(this).parents('.entry:first'),
                newEntry = $(currentEntry.clone()).appendTo(controlForm);

            newEntry.find('input').val('');
            controlForm.find('.entry:not(:last) .btn-chose-add')
                .removeClass('btn-chose-add').addClass('btn-remove')
                .removeClass('btn-success').addClass('btn-danger')
                .html('<span class="glyphicon glyphicon-minus"></span>');
        }).on('click', '.btn-remove', function(e)
        {
            $(this).parents('.entry:first').remove();

            e.preventDefault();
            return false;
        });
    });

    $(function()
    {
        $(document).on('click', '.btn-act-add', function(e)
        {
            e.preventDefault();

            var controlForm = $('#Activitefields .controls form:first'),
                currentEntry = $(this).parents('.entry:first'),
                newEntry = $(currentEntry.clone()).appendTo(controlForm);

            newEntry.find('input').val('');
            controlForm.find('.entry:not(:last) .btn-act-add')
                .removeClass('btn-act-add').addClass('btn-remove')
                .removeClass('btn-success').addClass('btn-danger')
                .html('<span class="glyphicon glyphicon-minus"></span>');
        }).on('click', '.btn-remove', function(e)
        {
            $(this).parents('.entry:first').remove();

            e.preventDefault();
            return false;
        });
    });



    $('#modal').modal("show");
</script>