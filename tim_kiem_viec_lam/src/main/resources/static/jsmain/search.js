// Function to perform the search using AJAX
function performSearch() {
    let title = $('#title-search').val();
    let location = $('#s-provinces').val();
    let companyName = $('#company-search').val();
    let skill = $('#computer-languages').val();

    $.ajax({
        type: 'GET',
        url: '/search',
        data: {
            title: title,
            location: location,
            skill: skill,
            name: companyName
        },
        success: function (data) {
            displaySearchResults(data.data);
        },
        error: function (error) {
            console.error('Error while searching:', error);
        }
    });
}

// Function to display the search results on the page
function displaySearchResults(jobs) {
    let searchResultsDiv = $('#job-group');
    searchResultsDiv.empty();

    if (jobs.length === 0) {
        searchResultsDiv.append('<p>No jobs found.</p>');
    } else {
        jobs.forEach(function (job) {
            let avatar = "/api/v1/files/" + job.avatar;
            let jobItem = `<div class="job pagi">
                            <div class="job-content">
                                <div class="job-logo">
                                    <a href="#">
                                        <img src="${avatar}" class="job-logo-ima"
                                             alt="job-logo">
                                    </a>
                                </div>
                                <div class="job-desc">
                                    <div class="job-title">
                                        <a href="#">${job.title}</a>
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
                                            <span class="salary-min">${job.salaryFrom}></span>
                                            <span class="salary-max">${job.salaryTo}</span>
                                        </div>
                                        <div class="job-deadline">
                                            <span><i class="fa fa-clock-o" aria-hidden="true"></i>  Hạn nộp: <strong>${job.dueDateTime}</strong></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="wrap-btn-appl">
                                    <a href="#" class="btn btn-appl">Apply Now</a>
                                </div>
                            </div>
                        </div>`;
            searchResultsDiv.append(jobItem);
        });

        $('.pagi').paginate(6);
    }
}

