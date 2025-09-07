from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/accounts/', include('accounts.urls')),
    path('api/packages/', include('packages.urls')),
    path('api/bookings/', include('bookings.urls')),
    # path('api/token/', include('rest_framework_simplejwt.urls')),
]
