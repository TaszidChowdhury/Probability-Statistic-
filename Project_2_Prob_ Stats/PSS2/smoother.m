function y_smoothed = smoother(x, y_noisy, window_size, file_name)
    % Apply a moving average smoothing operation
    y_smoothed = movmean(y_noisy, window_size); % Moving average

    % Save the smoothed data to a CSV file
    data = [x(:), y_smoothed(:)]; % Combine x and smoothed y into a single matrix
    csvwrite(file_name, data); % Write to CSV file
end

