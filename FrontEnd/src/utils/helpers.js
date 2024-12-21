export function formatNumber(number) {
    if (number < 1000)
        return number.toString();
    else if (number < 1e6)
        return (number / 1000) + 'k';
    else if (number < 1e9)
        return (number / 1e6) + 'M';
    else
        return (number / 1e9) + 'B';
}

export function ratingStars(number) {
    switch (number) {
        case 1:
            return "⭐";
        case 2:
            return "⭐⭐";
        case 3:
            return "⭐⭐⭐";
        case 4:
            return "⭐⭐⭐⭐";
        case 5:
            return "⭐⭐⭐⭐⭐";
        default:
            return "";
    }
}

export function formatDate(inputDate) {
    if (!inputDate)
        return "-";

    const dateParts = inputDate.split('-');
    const year = parseInt(dateParts[0], 10);
    const month = parseInt(dateParts[1], 10);
    const day = parseInt(dateParts[2], 10);

    const monthNames = [
        'Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
        'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'
    ];

    const formattedMonth = monthNames[month - 1];

    const formattedDate = `${formattedMonth} ${day}, ${year}`;

    return formattedDate;
}

export function convertDateFormat(inputDate) {
    if (!inputDate)
        return "";

    const isoDate = new Date(inputDate);
    const formattedDate = isoDate.toISOString().substring(0, 10);
    return formattedDate;
}

export function checkDateRange(startDate, endDate) {
    const today = new Date().toISOString();;
    startDate = new Date(startDate).toISOString();
    endDate = new Date(endDate).toISOString();

    if (today < startDate) {
        return 2; // coming soon
    } else if (today >= startDate && today <= endDate) {
        return 1; // going
    } else {
        return 3; // ended
    }
}
