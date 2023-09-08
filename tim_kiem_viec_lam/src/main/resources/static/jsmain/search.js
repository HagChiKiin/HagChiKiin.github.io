
$('#title-search, #company-search,#s-provinces,#computer-languages,#salaryFrom,#salaryTo').on('keydown', function(event) {
    if (event.key === 'Enter') {
        performSearch(); // Gọi hàm tìm kiếm khi nhấn Enter
    }
});

// Function to perform the search using AJAX
function performSearch() {
    let title = $('#title-search').val();
    let location = $('#s-provinces').val();
    let companyName = $('#company-search').val();
    let skill = $('#computer-languages').val();
    let salaryFrom = $('#salaryFrom').val();
    let salaryTo = $('#salaryTo').val();

    $.ajax({
        type: 'GET',
        url: '/search',
        data: {
            title: title,
            location: location,
            skill: skill,
            name: companyName,
            salaryFrom : salaryFrom,
            salaryTo : salaryTo
        },
        success: function (data) {
            displaySearchResults(data.data);
        },
        error: function (error) {
            console.error('Error while searching:', error);
        }
    });
}
function formatDateToYYYYMMDD(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // Thêm số 0 phía trước nếu tháng chỉ có một chữ số
    const day = String(date.getDate()).padStart(2, '0'); // Thêm số 0 phía trước nếu ngày chỉ có một chữ số
    return `${year}-${month}-${day}`;
}

function displayNoJobsFound() {
    const noJobsDiv = document.createElement('div');
    noJobsDiv.classList.add('no-jobs');
    const noJobsMessage = document.createElement('p');
    noJobsMessage.textContent = 'Không tìm thấy công việc nào';

    // Tùy chỉnh kiểu dáng của thông báo
    noJobsDiv.style.textAlign = 'center';
    noJobsMessage.style.fontSize = '22px';
    noJobsMessage.style.color = '#ff0000';
    noJobsMessage.style.marginTop = '20px';

    // Thêm thông báo vào trang web
    noJobsDiv.appendChild(noJobsMessage);
    document.getElementById('job-group').appendChild(noJobsDiv);
}


// Function to display the search results on the page
function displaySearchResults(jobs) {
    let searchResultsDiv = $('#job-group');
    searchResultsDiv.empty();

    if (jobs.length === 0) {
        displayNoJobsFound();
        $('.pagination').hide();
    } else {
        jobs.forEach(function (job) {
            const dueDate = new Date(job.dueDateTime);
            const formattedDueDate = formatDateToYYYYMMDD(dueDate);

            let avatar = "/api/v1/files/" + job.avatar;
            let salaryText = "";
            if (job.salaryFrom === 0 || job.salaryTo === 0) {
                salaryText = "Thỏa thuận";
            } else {
                salaryText = job.salaryFrom + " triệu - " + job.salaryTo + " triệu";
            }
            let jobItem = `<div class="job pagi">
                            <div class="job-content">
                                <div class="job-logo">
                                    <a href="/jd-page/${job.id}">
                                        <img src="${avatar}" class="job-logo-ima"
                                             alt="job-logo">
                                    </a>
                                </div>
                                <div class="job-desc">
                                    <div class="job-title">
                                        <a  href="/jd-page/${job.id}">${job.title}</a>
                                    </div>
                                    <div class="job-company">
                                        <a href="#">${job.companyName}</a> | <a href="#"
                                                                                    class="job-address"><i
                                                class="fa fa-map-marker" aria-hidden="true" > ${job.location}</i>
                                        </a>
                                    </div>
                                    <div class="job-inf">
                                        <div class="job-main-skill">
                                            <i class="fa fa-code" aria-hidden="true"></i> <a href="#">
                                            ${job.skill}</a>
                                        </div>
                                       <div class="job-salary">
                                            <i class="fa fa-money" aria-hidden="true"></i>
                                            <span class="salary-text">${salaryText}</span>
                                        </div>
                                        <div class="job-deadline">
                                            <span><i class="fa fa-clock-o" aria-hidden="true"></i>  Hạn nộp: <strong>${formattedDueDate}</strong></span>
                                        </div>
                                    </div>
                                </div>
                               
                            </div>
                        </div>`;
            searchResultsDiv.append(jobItem);
        });

        // Chỉ kích hoạt phân trang nếu có hơn 6 job tìm kiếm được
        if (jobs.length > 6) {
            $('.pagination').show();
            $('.pagi').paginate(6);
        } else {
            // Ẩn phân trang khi không có đủ công việc
            $('.pagination').hide();
        }

    }
}

