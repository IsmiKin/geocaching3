/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    $(document).ready(function(){
        
        $(".acciondetalles").hide();
        
        $(".btn-menudetalles").click(function(){
            
            var opcion =new String($(this).data("opcion"));            
            $("#logModal .modal-title").text(opcion);                                
            
        });
        
        // Es una 12"!$"*¨Ñ:_ porque JSF cambia los id de los cacharros.. muuuy bien
        $("#modalConfirmar").click(function(){
            $(".confirmarTesoro").show();
            $(".reportarTesoro").hide();
            $(".codigoValidacionInput").show();
            $("#codigoTesoro").val("");
            $("#comentarioTesoro").val("");
        });
        
        $("#modalReportar").click(function(){
            $(".confirmarTesoro").hide();
            $(".reportarTesoro").show();
            $(".codigoValidacionInput").hide();
            $("#codigoTesoro").val("");
            $("#comentarioTesoro").val("");
        });
        
    });

