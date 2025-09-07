from django.core.management.base import BaseCommand
from packages.models import Package, Category

class Command(BaseCommand):
    help = 'Seed the database with mock travel packages'

    def handle(self, *args, **kwargs):
        # Ensure categories exist or create them
        ooty_category, _ = Category.objects.get_or_create(name='Ooty')
        goa_category, _ = Category.objects.get_or_create(name='Goa')
        tirupati_category, _ = Category.objects.get_or_create(name='Tirupati')

        packages = [
            {
                'title': 'Ooty Delight',
                'description': 'Enjoy the scenic beauty of Ooty with this 3-day package.',
                'price': 15000,
                'duration': 3,
                'location': 'Ooty',
                'category': ooty_category,
            },
            {
                'title': 'Goa Beach Escape',
                'description': 'Relax on the beaches of Goa with this 5-day package.',
                'price': 25000,
                'duration': 5,
                'location': 'Goa',
                'category': goa_category,
            },
            {
                'title': 'Tirupati Pilgrimage',
                'description': 'Visit the holy temples of Tirupati with this 2-day package.',
                'price': 8000,
                'duration': 2,
                'location': 'Tirupati',
                'category': tirupati_category,
            },
        ]

        for pkg in packages:
            Package.objects.update_or_create(
                title=pkg['title'],
                defaults={
                    'description': pkg['description'],
                    'price': pkg['price'],
                    'duration': pkg['duration'],
                    'location': pkg['location'],
                    'category': pkg['category'],
                }
            )
        self.stdout.write(self.style.SUCCESS('Successfully seeded packages'))
