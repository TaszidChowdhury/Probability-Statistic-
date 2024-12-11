% Tester File for Various Densities, Salt, and Smooth Scenarios

% PLOTTER PHASE
figure;

% Small Sample: Low density
x_small = 10:1:10;
y_small = x_small.^2 - 2.*x_small + 1;
subplot(4, 1, 1);
plotter(x_small, y_small, 'Small Sample: Low Density (10 to 10, interval 1)', 'plot_small.csv');

% Small Sample 2: Very low density
x_small2 = 0:5:50;
y_small2 = x_small2.^2 - 2.*x_small2 + 1;
subplot(4, 1, 2);
plotter(x_small2, y_small2, 'Small Sample 2: Very Low Density (0 to 50, interval 5)', 'plot_small2.csv');

% Large Sample: High density
x_large = -100:0.01:100;
y_large = x_large.^2 - 2.*x_large + 1;
subplot(4, 1, 3);
plotter(x_large, y_large, 'Large Sample: High Density (-100 to 100, interval 0.01)', 'plot_large.csv');

% Large Sample 2: Moderate density
x_large2 = 0:0.1:1000;
y_large2 = x_large2.^2 - 2.*x_large2 + 1;
subplot(4, 1, 4);
plotter(x_large2, y_large2, 'Large Sample 2: Moderate Density (0 to 1000, interval 0.1)', 'plot_large2.csv');

% SALTER PHASE
figure;

% Small Sample: Salt range = 5
y_small_salted = salter(x_small, y_small, 5, 'salt_small.csv');
subplot(4, 1, 1);
plot(x_small, y_small_salted, 'r.', 'MarkerSize', 8);
title('Small Sample: Salt Range = 5');
grid on;

% Small Sample 2: Salt range = 20
y_small2_salted = salter(x_small2, y_small2, 20, 'salt_small2.csv');
subplot(4, 1, 2);
plot(x_small2, y_small2_salted, 'r.', 'MarkerSize', 8);
title('Small Sample 2: Salt Range = 20');
grid on;

% Large Sample: Salt range = 5
y_large_salted = salter(x_large, y_large, 5, 'salt_large.csv');
subplot(4, 1, 3);
plot(x_large, y_large_salted, 'r.', 'MarkerSize', 2);
title('Large Sample: Salt Range = 5');
grid on;

% Large Sample 2: Salt range = 50
y_large2_salted = salter(x_large2, y_large2, 50, 'salt_large2.csv');
subplot(4, 1, 4);
plot(x_large2, y_large2_salted, 'r.', 'MarkerSize', 2);
title('Large Sample 2: Salt Range = 50');
grid on;

% SMOOTHER PHASE
figure;

% Small Sample: Smooth window = 2
y_small_smoothed = smoother(x_small, y_small_salted, 2, 'smooth_small.csv');
subplot(4, 1, 1);
plot(x_small, y_small_smoothed, 'g-', 'LineWidth', 2);
title('Small Sample: Smoothed (Window = 2)');
grid on;

% Small Sample 2: Smooth window = 3
y_small2_smoothed = smoother(x_small2, y_small2_salted, 3, 'smooth_small2.csv');
subplot(4, 1, 2);
plot(x_small2, y_small2_smoothed, 'g-', 'LineWidth', 2);
title('Small Sample 2: Smoothed (Window = 3)');
grid on;

% Large Sample: Smooth window = 10
y_large_smoothed = smoother(x_large, y_large_salted, 10, 'smooth_large.csv');
subplot(4, 1, 3);
plot(x_large, y_large_smoothed, 'g-', 'LineWidth', 2);
title('Large Sample: Smoothed (Window = 10)');
grid on;

% Large Sample 2: Smooth window = 50
y_large2_smoothed = smoother(x_large2, y_large2_salted, 50, 'smooth_large2.csv');
subplot(4, 1, 4);
plot(x_large2, y_large2_smoothed, 'g-', 'LineWidth', 2);
title('Large Sample 2: Smoothed (Window = 50)');
grid on;

