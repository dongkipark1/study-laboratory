document.querySelectorAll('.profile-item img').forEach(item => {
    item.addEventListener('click', () => {
      // 프로필 사진을 변경
      const profilePic = document.getElementById('currentProfilePic');
      profilePic.src = item.src;
    });
  });
  
  // 뒤로가기 버튼 이벤트 리스너 (필요에 맞게 수정)
  document.querySelector('.back-button').addEventListener('click', () => {
    window.history.back();
  });

  
  
  // 오른쪽 스크롤 버튼
  const profileContainer = document.querySelector('.profile-container');
  const scrollRight = document.getElementById('scrollRight');
  const scrollLeft = document.getElementById('scrollLeft');
  
  scrollRight.addEventListener('click', () => {
    profileContainer.scrollBy({
      left: 200,
      behavior: 'smooth'
    });
  });

  scrollLeft.addEventListener('click', () => {
    profileContainer.scrollBy({
      left: -200,
      behavior: 'smooth'
    });
  });
  