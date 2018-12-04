$.fn.datepicker.dates['fr'] = {
    days: ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"],
    daysShort: ["Dim.", "Lun.", "Mar.", "Mer.", "Jeu.", "Ven.", "Sam."],
    daysMin: ["Di", "Lu", "Ma", "Me", "Je", "Ve", "Sa"],
    months: ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"],
    monthsShort: ["Janv.", "Févr.", "Mars", "Avr.", "Mai", "Juin", "Juil.", "Août", "Sept.", "Oct.", "Nov.", "Déc."],
    today: "Aujourd'hui",
    clear: "Effacer",
    format: "dd/mm/yyyy",
    titleFormat: "MM yyyy",
    weekStart: 1
};

$(function () {
    $('.input-group.date').datepicker({
        autoclose: true,
        clearBtn: true,
        language: 'fr'
    });

    // OnStartup
    $('#form-advanced-search').hide();
    // Show Advanced Search
    $('#btn-advanced-search').click(function() {
        $('#form-search').hide();
        $('#form-advanced-search').show();
    });
    // Show Simple Search
    $('#btn-search').click(function() {
        $('#form-search').show();
        $('#form-advanced-search').hide();
    });

    submitForm = function (page) {
        $('#page-number').val(page);
        $('#form-search').submit();
    };

    submitFormAdvanced = function (page) {
        $('#page-number-advanced').val(page);
        $('#form-advanced-search').submit();
    };
});

// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
    'use strict';
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();