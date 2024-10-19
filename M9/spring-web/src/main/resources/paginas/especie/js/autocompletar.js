<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      lang="es">
<body>
<script type="text/javascript" th:fragment="jsespecie">
        $(document).ready(function(){
        $("#nombre").autocomplete({
            source: function(request,response){
              $.ajax({
                    url:"/especie/buscar-especie-nombre/"+request.term,
                    dataType:"json",
                    data:{
                        term: request.term
                    },
                    success: function(data){
                        response($.map(data,function(item){
                            return{
                                 value:item.id_epe,
                                 label:item.nombre,
                            };
                        }));
                    },
              });
            },
            select: function(event,ui){
               $("#nombre").val(ui.item.label);
               $("#idEspecie").val(ui.item.value);
               return false;
            }
        });
    }
    );


</script>
</body>
</html>