from django.urls import path
from . import views

urlpatterns = [
    path('categories/', views.CategoryList.as_view(), name='category-list'),
    path('', views.PackageList.as_view(), name='package-list'),
    path('<int:pk>/', views.PackageDetail.as_view(), name='package-detail'),
]
