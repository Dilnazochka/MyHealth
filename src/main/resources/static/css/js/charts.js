document.addEventListener('DOMContentLoaded', function () {
    const ctx = document.getElementById('testChart');
    if (!ctx) return;
    try {
        new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Values',
                    data: values,
                    fill: false,
                    tension: 0.1
                }]
            },
            options: { scales: { y: { beginAtZero: false } } }
        });
    } catch (e){ console.error(e); }
});