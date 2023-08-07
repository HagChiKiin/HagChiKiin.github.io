// Function to perform the search using AJAX
function performSearch() {
    var keyword = $('#keyword').val();
    var language = $('#language').val();
    var location = $('#location').val();
    var skill = $('#computer-languages').val()

    $.ajax({
        type: 'GET',
        url: '/search',
        data: {
            keyword: keyword,
            language: language,
            location: location,
            skill: skill
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
    var searchResultsDiv = $('#job-group');
    searchResultsDiv.empty();

    if (jobs.length === 0) {
        searchResultsDiv.append('<p>No jobs found.</p>');
    } else {
        $.each(jobs, function (index, job) {
            var avartar = "/api/v1/files/" + job.avatar;
            var jobItem = $('<div class="job pagi">\n' +
                '                <div class="job-content">\n' +
                '                    <div class="job-logo">\n' +
                '                        <a href="#">\n' +
                '                            <img src="'+avartar+'" class="job-logo-ima"\n' +
                '                                 alt="job-logo">\n' +
                '                        </a>\n' +
                '                    </div>\n' +
                '\n' +
                '                    <div class="job-desc">\n' +
                '                        <div class="job-title">\n' +
                '                            <a href="#" >'+job.title+'</a>\n' +
                '                        </div>\n' +
                '                        <div class="job-company">\n' +
                '                            <a href="#" >'+job.companyName+'</a> | <a href="#"\n' +
                '                                                                                                 class="job-address"><i\n' +
                '                            class="fa fa-map-marker" aria-hidden="true"></i>\n' +
                '                            Hà Nội</a>\n' +
                '                        </div>\n' +
                '\n' +
                '                        <div class="job-inf">\n' +
                '                            <div class="job-main-skill">\n' +
                '                                <i class="fa fa-code" aria-hidden="true"></i> <a href="#"\n' +
                '                                                                                     >\n' +
                '                                '+job.skill+'</a>\n' +
                '                            </div>\n' +
                '                            <div class="job-salary">\n' +
                '                                <i class="fa fa-money" aria-hidden="true"></i>\n' +
                '                                <span class="salary-min" >'+job.salaryFrom+'<em\n' +
                '                                    class="salary-unit">triệu</em></span>\n' +
                '                                <span class="salary-max" >'+job.salaryTo+' <em\n' +
                '                                    class="salary-unit">triệu</em></span>\n' +
                '                            </div>\n' +
                '                            <div class="job-deadline">\n' +
                '                                            <span><i class="fa fa-clock-o" aria-hidden="true"></i>  Hạn nộp: <strong\n' +
                '                                                >'+job.dueDateTime+'/strong></span>\n' +
                '                            </div>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                    <div class="wrap-btn-appl">\n' +
                '                        <a href="#" class="btn btn-appl">Apply Now</a>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>');
            // Add more job details as needed

            searchResultsDiv.append(jobItem);
        });
    }
}

// Attach the submit event to the search form
$('#searchForm').submit(function (event) {
    event.preventDefault();
    performSearch();
});
