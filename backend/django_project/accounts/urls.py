from django.urls import path
from . import views

urlpatterns = [
    path('register/', views.UserList.as_view(), name='user-register'),
    path('profile/', views.UserProfileDetail.as_view(), name='user-profile'),
    path('login/', views.MyTokenObtainPairView.as_view(), name='token_obtain_pair'),
]
