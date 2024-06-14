$(document).ready(function() {
    // 프로필 사진 변경 기능
    $('#profile-pic-upload').change(function(event) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#profile-pic').attr('src', e.target.result);
        }
        reader.readAsDataURL(event.target.files[0]);
    });

    // 관람등급 변경 기능
    const restrictionButton = $('#restriction-button');
    const restrictionLevel = $('#restriction-level');
    const restrictionLevels = ['모든 관람등급', '7세 미만', '15세 미만', '19세 이상'];
    let currentLevelIndex = 0;

    restrictionButton.click(function() {
        currentLevelIndex = (currentLevelIndex + 1) % restrictionLevels.length;
        restrictionLevel.text(restrictionLevels[currentLevelIndex]);
    });
});
